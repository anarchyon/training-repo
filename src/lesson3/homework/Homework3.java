package lesson3.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework3 {

    public static char[][] map;
    public static final char HUMAN_TURN = 'X';
    public static final char AI_TURN = 'O';
    public static final char EMPTY_CELL = '_';
    public static final int fieldSizeX = 3;
    public static final int fieldSizeY = 3;
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static void initGame() {
        map = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                map[y][x] = EMPTY_CELL;
            }
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
        map[y][x] = HUMAN_TURN;
    }

    public static void aiTurn() {
        System.out.println("Ход компьютера:");
        int x, y;
        do {
            x = RANDOM.nextInt(3);
            y = RANDOM.nextInt(3);
        } while (isOutOfBounds(x, y) || isNotEmptyCell(x, y));
        map[y][x] = AI_TURN;
    }

    public static boolean isOutOfBounds(int x, int y) {
        return x < 0 || x >= fieldSizeX || y < 0 || y >= fieldSizeY;
    }

    public static boolean isNotEmptyCell(int x, int y) {
        return map[y][x] != EMPTY_CELL;
    }

    public static boolean isDraw(){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (map[y][x] == EMPTY_CELL) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
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
