package lesson7.homework;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JFrame {

    private final int SIZE_X = 350;
    private final int SIZE_Y = 500;
    private final String TITLE = "Настройки";
    private final String MODE = "Выберите режим игры";
    private final String DIFFICULTY = "Выберите сложность игры";
    private final String DIFFICULTY_EASY = "Легко";
    private final String DIFFICULTY_NORMAL = "Нормально";
    private final String DIFFICULTY_HARD = "Сложно";
    private final String FIELD_SIZE = "Выберите размер поля";
    private final String WIN_SERIES = "Выберите длину выигрышной комбинации";
    private final String HUM_VS_AI = "Человек против ИИ";
    private final String HUM_VS_HUM = "Человек против человека";
    private final String LINES_COUNT = "Число строк поля: %s";
    private final String COLUMNS_COUNT = "Число столбцов поля: %s";
    private final String WIN_SERIES_COUNT = "Выигрышная комбинация: %s";
    private final String START_GAME = "Запустить игру";

    JRadioButton rbHumVsAI;
    JRadioButton rbHumVsHum;
    JRadioButton rbDifficultyEasy;
    JRadioButton rbDifficultyNormal;
    JRadioButton rbDifficultyHard;
    JSlider sliderLines;
    JSlider sliderColumns;
    JSlider sliderWin;

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 12;
    private final int MIN_WIN_SERIES = 3;

    MainWindow mainWindow;

    Settings(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setSize(SIZE_X, SIZE_Y);
        Rectangle box = mainWindow.getBounds();
        setLocation((int)box.getCenterX() - SIZE_X / 2, (int)box.getCenterY() - SIZE_Y / 2);
        setResizable(false);
        setTitle(TITLE);
        setAlwaysOnTop(true);
        setLayout(new GridLayout(16, 1));
        addControls();
    }

    private void addControls() {
        //режимы игры, режим "человек против человека" пока не реализован
        JLabel lblMode = new JLabel(MODE);
        ButtonGroup bgMode = new ButtonGroup();
        rbHumVsAI = new JRadioButton(HUM_VS_AI, true);
        rbHumVsHum = new JRadioButton(HUM_VS_HUM);
        rbHumVsHum.setEnabled(false);
        bgMode.add(rbHumVsAI);
        bgMode.add(rbHumVsHum);

        //сложность игры, сложность "сложно" пока не реализована
        JLabel lblDifficulty = new JLabel(DIFFICULTY);
        ButtonGroup bgDifficulty = new ButtonGroup();
        rbDifficultyEasy = new JRadioButton(DIFFICULTY_EASY);
        rbDifficultyNormal = new JRadioButton(DIFFICULTY_NORMAL, true);
        rbDifficultyHard = new JRadioButton(DIFFICULTY_HARD);
        rbDifficultyHard.setEnabled(false);
        bgDifficulty.add(rbDifficultyEasy);
        bgDifficulty.add(rbDifficultyNormal);
        bgDifficulty.add(rbDifficultyHard);

        //ползунки выбора размеров поля
        JLabel lblFieldSize = new JLabel(FIELD_SIZE);
        sliderLines = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderColumns = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        JLabel lblLinesCount = new JLabel(String.format(LINES_COUNT, sliderLines.getValue()));
        JLabel lblColumnsCount = new JLabel(String.format(COLUMNS_COUNT, sliderColumns.getValue()));

        //ползунки выбора длины выигрышной серии
        JLabel lblWinSeries = new JLabel(WIN_SERIES);
        sliderWin = new JSlider(MIN_WIN_SERIES, MIN_FIELD_SIZE, MIN_WIN_SERIES);
        JLabel lblWinSeriesCount = new JLabel(String.format(WIN_SERIES_COUNT, sliderWin.getValue()));

        sliderLines.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblLinesCount.setText(String.format(LINES_COUNT, sliderLines.getValue()));
                sliderWin.setMaximum(getMinimumOfCurrentSize());
            }
        });
        sliderColumns.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblColumnsCount.setText(String.format(COLUMNS_COUNT, sliderColumns.getValue()));
                sliderWin.setMaximum(getMinimumOfCurrentSize());
            }
        });
        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lblWinSeriesCount.setText(String.format(WIN_SERIES_COUNT, sliderWin.getValue()));
            }
        });

        //кнопка запуска игры
        JButton btnStartGame = new JButton(START_GAME);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTheGame();
            }
        });

        //добавление всех элементов на окно
        add(lblMode);
        add(rbHumVsAI);
        add(rbHumVsHum);
        add(lblDifficulty);
        add(rbDifficultyEasy);
        add(rbDifficultyNormal);
        add(rbDifficultyHard);
        add(lblFieldSize);
        add(lblLinesCount);
        add(sliderLines);
        add(lblColumnsCount);
        add(sliderColumns);
        add(lblWinSeries);
        add(lblWinSeriesCount);
        add(sliderWin);
        add(btnStartGame);
    }

    private void startTheGame() {
        int gameMode, gameDifficulty, lines, columns, winSeries;

        if (rbHumVsAI.isSelected()) {
            gameMode = GameMap.HUM_VS_AI_MODE;
        } else if (rbHumVsHum.isSelected()) {
            gameMode = GameMap.HUM_VS_HUM_MODE;
        } else {
            throw new RuntimeException("Необработанный режим игры!");
        }

        if (rbDifficultyEasy.isSelected()) {
            gameDifficulty = GameMap.GAME_DIFFICULTY_AI_EASY;
        } else if (rbDifficultyNormal.isSelected()) {
            gameDifficulty = GameMap.GAME_DIFFICULTY_AI_NORMAL;
        } else if (rbDifficultyHard.isSelected()) {
            gameDifficulty = GameMap.GAME_DIFFICULTY_AI_HARD;
        } else  {
            throw new RuntimeException("Необработанная сложность игры!");
        }

        lines = sliderLines.getValue();
        columns = sliderColumns.getValue();
        winSeries = sliderWin.getValue();
        mainWindow.startNewGame(gameMode, gameDifficulty, lines, columns, winSeries, MAX_FIELD_SIZE);
        setVisible(false);
    }

    private int getMinimumOfCurrentSize() {
        int currentLines = sliderLines.getValue();
        int currentColumns = sliderColumns.getValue();
        return Math.min(currentLines, currentColumns);
    }
}
