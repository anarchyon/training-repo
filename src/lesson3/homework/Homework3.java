package lesson3.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework3 {

    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = 'O';
    public static final char EMPTY_DOT = '_';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static char[][] map;
    public static int fieldSizeX;
    public static int fieldSizeY;
    public static int winSeries;

    public static void gameSettings() {
        fieldSizeX = 3;
        fieldSizeY = 3;
        winSeries = 3;
    }

    public static void initGame() {
        map = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                map[y][x] = EMPTY_DOT;
            }
            System.out.println();
        }
    }

    public static void printField() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        System.out.println("Введите координаты своего хода (отсчет с левого верхнего угла):");
        int x, y;
        do {
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (isOutOfBounds(x, y) || isNotEmptyCell(x, y));
        map[y][x] = HUMAN_DOT;
    }

    public static void aiTurn() {
        System.out.println("Ход компьютера:");
        int x, y;
        do {
            x = RANDOM.nextInt(3);
            y = RANDOM.nextInt(3);
        } while (isOutOfBounds(x, y) || isNotEmptyCell(x, y));
        map[y][x] = AI_DOT;
    }

    public static boolean isOutOfBounds(int x, int y) {
        return x < 0 || x >= fieldSizeX || y < 0 || y >= fieldSizeY;
    }

    public static boolean isNotEmptyCell(int x, int y) {
        return map[y][x] != EMPTY_DOT;
    }

    public static boolean isDraw(){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (map[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    public static boolean isVictory(char playerChar) {
        //длину выигрышного ряда соотносим с длиной вертикали и диагонали, т.е. длина горизонтали.вертикали
        //минус длина выигрышного ряда - максимальныц номер ячейки, с которой стоит искать
//        int stopCellX, stopCellY;
//        stopCellX = fieldSizeX - WIN_SERIES;
//        stopCellY = (fieldSizeY == fieldSizeX) ? stopCellX : fieldSizeY - WIN_SERIES;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (map[y][x] != playerChar) continue;
                boolean h = true, v = true, d = true, nd = true;
                for (int i = 0; i < winSeries; i++) {
                    //if (h && )
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        gameSettings();
        initGame();
        printField();
        while (true) {
            humanTurn();
            printField();
            if (isDraw()){
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            printField();
            if (isDraw()){
                System.out.println("Ничья!");
                break;
            }

        }
    }
}
