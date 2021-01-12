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
        setLayout(new GridLayout(12,1));

        addControls();
    }

    private void addControls() {
        JLabel lblMode = new JLabel(MODE);
        JLabel lblFieldSize = new JLabel(FIELD_SIZE);
        JLabel lblWinSeries = new JLabel(WIN_SERIES);

        ButtonGroup bgMode = new ButtonGroup();
        rbHumVsAI = new JRadioButton(HUM_VS_AI, true);
        rbHumVsHum = new JRadioButton(HUM_VS_HUM);
        bgMode.add(rbHumVsAI);
        bgMode.add(rbHumVsHum);

        sliderLines = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderColumns = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderWin = new JSlider(MIN_WIN_SERIES, MIN_FIELD_SIZE, MIN_WIN_SERIES);
        JLabel lblLinesCount = new JLabel(String.format(LINES_COUNT, sliderLines.getValue()));
        JLabel lblColumnsCount = new JLabel(String.format(COLUMNS_COUNT, sliderColumns.getValue()));
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

        JButton btnStartGame = new JButton(START_GAME);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTheGame();
            }
        });

        add(lblMode);
        add(rbHumVsAI);
        add(rbHumVsHum);
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
        int gameMode, fieldSizeX, fieldSizeY, winSeries;
        if (rbHumVsAI.isSelected()) {
            gameMode = GameMap.HUM_VS_AI_MODE;
        } else if (rbHumVsHum.isSelected()) {
            gameMode = GameMap.HUM_VS_HUM_MODE;
        } else {
            throw new RuntimeException("Неизвестный режим игры!");
        }
        fieldSizeX = sliderLines.getValue();
        fieldSizeY = sliderColumns.getValue();
        winSeries = sliderWin.getValue();
        mainWindow.startNewGame(gameMode, fieldSizeX, fieldSizeY, winSeries, MAX_FIELD_SIZE);
        setVisible(false);
    }

    private int getMinimumOfCurrentSize() {
        int currentLines = sliderLines.getValue();
        int currentColumns = sliderColumns.getValue();
        return Math.min(currentLines, currentColumns);
    }
}
