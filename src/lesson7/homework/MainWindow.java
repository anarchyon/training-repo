package lesson7.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private final int SIZE_X = 450;
    private final int SIZE_Y = 600;
    private final int POS_X = 400;
    private final int POS_Y = 200;

    GameMap gameMap;
    Settings settings;

    MainWindow() {
        setSize(SIZE_X, SIZE_Y);
        setLocation(POS_X, POS_Y);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Крестики - Нолики");

        settings = new Settings(this);
        gameMap = new GameMap();
        add(gameMap);
        addButtons();

        setVisible(true);
    }

    private void addButtons() {
        JButton btnStart = new JButton("Запуск игры");
        JButton btnExit = new JButton("Выход");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, 2));
        panelButtons.add(btnStart);
        panelButtons.add(btnExit);
        add(panelButtons, BorderLayout.SOUTH);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winSeries, final int MAX_FIELD_SIZE) {
        gameMap.startNewGame(mode, fieldSizeX, fieldSizeY, winSeries, MAX_FIELD_SIZE);
    }
}
