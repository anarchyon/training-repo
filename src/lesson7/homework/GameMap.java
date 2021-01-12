package lesson7.homework;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {

    static final int HUM_VS_HUM_MODE = 1;
    static final int HUM_VS_AI_MODE = 0;
    final int INDENT = 10;
    int mode;
    int fieldSizeX;
    int fieldSizeY;
    int winSeries;
    int gridStep;

    GameMap() {
        setBackground(Color.ORANGE);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winSeries, final int MAX_FIELD_SIZE) {
        this.mode = mode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winSeries = winSeries;
        gridStep = Math.min((getHeight() - INDENT * 2) / MAX_FIELD_SIZE, (getWidth() - INDENT * 2) / MAX_FIELD_SIZE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
        repaint();
    }

    private void drawGrid(Graphics g) {
        for (int i = 1; i < fieldSizeY; i++) {
            g.drawLine(gridStep * i + INDENT, INDENT, gridStep * i + INDENT, gridStep * fieldSizeX + INDENT);
        }
        for (int i = 1; i < fieldSizeX; i++) {
            g.drawLine(INDENT, gridStep * i + INDENT, gridStep * fieldSizeY + INDENT, gridStep * i + INDENT);
        }
    }
}
