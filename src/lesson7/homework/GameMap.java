package lesson7.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GameMap extends JPanel {

    static final int HUM_VS_HUM_MODE = 1;
    static final int HUM_VS_AI_MODE = 0;
    private int mode;

    private final int GAME_DIFFICULT_AI_NOT_PLAYING = 0;
    private final int GAME_DIFFICULT_AI_EASY = 1;
    private final int GAME_DIFFICULT_AI_NORMAL = 2;
    private final int GAME_DIFFICULT_AI_HARD = 3;
    private int currentGameDifficult;

    private final int STATE_GAME_PREPARING = -1;
    private final int STATE_GAME_PLAYING = 0;
    private final int STATE_DRAW = 1;
    private final int STATE_WIN_HUMAN = 2;
    private final int STATE_WIN_AI = 3;
    private int currentState;

    final int INDENT = 10;

    final int DOT_HUMAN = 1;
    final int DOT_AI = 2;
    final int DOT_EMPTY = 0;

    private int lines;
    private int columns;
    private int winSeries;
    private int gridStep;
    private int[][] map;
    private Random random = new Random();

    GameMap() {
        setBackground(Color.ORANGE);
        currentState = STATE_GAME_PREPARING;
    }

    public void startNewGame(int mode, int lines, int columns, int winSeries, final int MAX_FIELD_SIZE) {
        this.mode = mode;
        this.lines = lines;
        this.columns = columns;
        this.winSeries = winSeries;
        gridStep = Math.min((getHeight() - INDENT * 2) / MAX_FIELD_SIZE, (getWidth() - INDENT * 2) / MAX_FIELD_SIZE);
        map = new int[lines][columns];
        currentState = STATE_GAME_PLAYING;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                readClick(e);
            }
        });
    }

    private void readClick(MouseEvent e) {
        if (currentState != STATE_GAME_PLAYING) {
            return;
        }
        int column = (e.getX() - INDENT) / gridStep;
        int line = (e.getY() - INDENT) / gridStep;
        if (isInField(line, column) && isEmptyCell(line, column)) {
            map[line][column] = DOT_HUMAN;
            if (isVictory(DOT_HUMAN)) {
                currentState = STATE_WIN_HUMAN;
                return;
            }
            if (isDraw()) {
                currentState = STATE_DRAW;
                return;
            }
            aiTurn();
            if (isVictory(DOT_AI)) {
                currentState = STATE_WIN_AI;
                return;
            }
            if (isDraw()) {
                currentState = STATE_DRAW;
                return;
            }
        }
    }

    private boolean isInField(int lines, int columns) {
        return lines >= 0 && lines < this.lines && columns >= 0 && columns < this.columns;
    }

    private boolean isEmptyCell(int lines, int columns) {
        return map[lines][columns] == DOT_EMPTY;
    }

    private boolean isDraw() {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isVictory(int dot) {
        for (int line = 0; line < lines; line++) {
            for (int column = 0; column < columns; column++) {
                //проверяю 4 направления, вектор пересчитываю через sin-cos
                for (int i = 0; i < 4; i++) {
                    int dLine = (int) Math.round(Math.cos(i * Math.PI / 4));
                    int dColumn = (int) Math.round(Math.sin(i * Math.PI / 4));
                    if (checkSeries(line, column, dLine, dColumn, dot)) return true;
                }
            }
        }
        return false;
    }

    private boolean checkSeries(int line, int column, int dLine, int dColumn, int dot) {
        int endLine = line + (winSeries - 1) * dLine;
        if (endLine >= lines || endLine < 0) return false;
        int endColumn = column + (winSeries - 1) * dColumn;
        if (endColumn >= columns || endColumn < 0) return false;
        for (int i = 0; i < winSeries; i++) {
            if (map[line + (dLine * i)][column + (dColumn * i)] != dot) return false;
        }
        return true;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(lines);
            y = random.nextInt(columns);
        } while (!isEmptyCell(x, y));
        map[x][y] = DOT_AI;
        /*
        if (isEmptyCell(aiX, aiY)) {
            System.out.println("Что-то пошло не так!!!!!!!!");
        } else {
            map[aiY][aiX] = AI_DOT;
        }

         */
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawer(g);
        repaint();
    }

    private void drawer(Graphics g) {
        int x, y;
        for (int i = 1; i < columns; i++) {
            x = gridStep * i + INDENT;
            y = gridStep * lines + INDENT;
            g.drawLine(x, INDENT, x, y);
        }
        for (int i = 1; i < lines; i++) {
            x = gridStep * columns + INDENT;
            y = gridStep * i + INDENT;
            g.drawLine(INDENT, y, x, y);
        }
        for (int line = 0; line < lines; line++) {
            for (int column = 0; column < columns; column++) {
                x = column * gridStep + INDENT;
                y = line * gridStep + INDENT;
                switch (map[line][column]) {
                    case DOT_AI:
                        g.drawOval(x, y, gridStep, gridStep);
                        break;
                    case DOT_HUMAN:
                        g.drawLine(x, y, x + gridStep, y + gridStep);
                        g.drawLine(x, y + gridStep, x + gridStep, y);
                        break;
                }
            }
        }
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    public int getSTATE_GAME_PREPARING() {
        return STATE_GAME_PREPARING;
    }
}
