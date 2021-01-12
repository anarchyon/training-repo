package facultative1;

import java.util.Scanner;

public class Start {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int maxValue = 9;
        int playerTry = 3;
        int continueGame;
        Game game;

        do {
            game = new Game(maxValue, playerTry);
            game.playerTurn();
            if (game.isGameWin()) System.out.println("Победа!");
            else System.out.println("Ты не угадал число!");
            continueGame = scanner.nextInt();
        } while (continueGame == 1);

    }
}
