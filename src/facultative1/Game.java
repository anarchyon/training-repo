package facultative1;

import java.util.Scanner;

public class Game {

    private final String TITLE = "Компьютер загадал число от 0 до %s. Попробуй угадать! У тебя есть %s попытки\n";
    private final String INVITE = "Введи целое число:";
    private final String WIN = "Ты угадал!!! Загаданное число - %s, количество потраченных попыток: %s";

    private int maxValue;
    private int playerTry;
    private HiddenNumber hiddenNumber;
    private Scanner scanner = new Scanner(System.in);
    private boolean gameWin;

    public Game(int maxValue, int playerTry) {
        this.maxValue = maxValue;
        this.playerTry = playerTry;
        hiddenNumber = new HiddenNumber(maxValue);
    }

    public void playerTurn() {
        for (int i = playerTry; i > 0; i--) {
            System.out.printf(TITLE, getMaxValue(), getPlayerTry());
            System.out.println(INVITE);
            int playerNumber = scanner.nextInt();
            gameWin = playerNumber == hiddenNumber.getNumber();
            if (isGameWin()) break;
        }
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getPlayerTry() {
        return playerTry;
    }

    public boolean isGameWin() {
        return gameWin;
    }
}
