package lesson3.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework3 {

    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = 'O';
    public static final char EMPTY_DOT = '_';
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();
    public static final int IS_VICTORY = 0;
    public static final int AI_DOTS_CHECK = 1;
    public static final int HUMAN_DOTS_CHECK = 2;

    public static char[][] map;
    public static int fieldSizeX;
    public static int fieldSizeY;
    public static int winSeries;

    public static int delta;
    public static int aiX;
    public static int aiY;
    public static int sumOfAllFears = 0;


    public static void gameSettings() {
        fieldSizeX = 12;
        fieldSizeY = 9;
        winSeries = 6;
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
        /*int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (isOutOfBounds(x, y) || isNotEmptyCell(x, y));*/
        if (isNotEmptyCell(aiX, aiY)) {
            System.out.println("Что-то пошло не так!!!!!!!!");
        } else {
            map[aiY][aiX] = AI_DOT;
        }
    }

    public static boolean isOutOfBounds(int x, int y) {
        return x < 0 || x >= fieldSizeX || y < 0 || y >= fieldSizeY;
    }

    public static boolean isNotEmptyCell(int x, int y) {
        return map[y][x] != EMPTY_DOT;
    }

    public static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (map[y][x] == EMPTY_DOT) return false;
            }
        }
        return true;
    }

    //первый созданный метод проверки на победу
    public static boolean isVictoryMod1(char playerChar) {
        boolean h = true, v = true, d = true, nd = true;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (map[y][x] != playerChar) continue;
                h = v = d = nd = true;
                if (x + winSeries > fieldSizeX) {
                    h = d = nd = false;
                }
                if (y + winSeries > fieldSizeY) {
                    v = d = false;
                }
                if (y - winSeries + 1 < 0) {
                    nd = false;
                }
                if (!h && !v && !d && !nd) continue;
                for (int i = 1; i < winSeries; i++) {
                    if (!(h && map[y][x + i] == playerChar)) {
                        h = false;
                    }
                    if (!(v && map[y + i][x] == playerChar)) {
                        v = false;
                    }
                    if (!(d && map[y + i][x + i] == playerChar)) {
                        d = false;
                    }
                    if (!(nd && map[y - i][x + i] == playerChar)) {
                        nd = false;
                    }
                    if (!h && !v && !d && !nd) break;
                }
                if (h || v || d || nd) return true;
            }
        }
        return false;
    }

    //метод создан после подсказки про векторы, спасибо, Александр :)
    //метод конечно не лаконичен, но вроде работает, заодно выбирает ход для компьютера
    //не придумал как расшарить сбор массивчика длиной в победную серию на разные методы
    public static boolean analyzeMap(char playerDot, int typeOfAnalyze) {
        char[] arrayForChecking = new char[winSeries];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                arrayForChecking[0] = map[i][j];
                for (int v = 0; v < 4; v++) {
                    int x = j, y = i;
                    int dX = (int) Math.round(Math.cos((v * 45.0) * Math.PI / 180));
                    int dY = (int) Math.round(Math.sin((v * 45.0) * Math.PI / 180));
                    if (isOutOfBounds(x + (winSeries - 1) * dX, y + (winSeries - 1) * dY)) continue;
                    for (int k = 1; k < winSeries; k++) {
                        x += dX;
                        y += dY;
                        arrayForChecking[k] = map[y][x];
                    }
                    switch (typeOfAnalyze) {
                        case IS_VICTORY:
                            if (isFound2(arrayForChecking, playerDot)) return true;
                            break;
                        case AI_DOTS_CHECK:
                            if (aiDotsCheck(arrayForChecking)) {
                                aiX = x - delta * dX;
                                aiY = y - delta * dY;
                                return true;
                            }
                            break;
                        case HUMAN_DOTS_CHECK:
                            if (humanDotsCheck(arrayForChecking)) {
                                aiX = x - delta * dX;
                                aiY = y - delta * dY;
                            }
                            break;
                    }
                }
            }
        }
        return false;
    }

    public static boolean aiDotsCheck(char[] array) {
        int sum = 0;
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == AI_DOT) {
                sum++;
            } else if (array[i] == EMPTY_DOT) {
                pos = i;
            }
        }
        if (sum == array.length - 1 && pos >= 0) {
            delta = array.length - 1 - pos;
            return true;
        }
        return false;
    }

    public static boolean humanDotsCheck(char[] array) {
        int sum = 0;
        int pos = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == HUMAN_DOT) {
                sum++;
                if (i + 1 < array.length && array[i + 1] == EMPTY_DOT) {
                    pos = i + 1;
                }
            } else if (array[i] == EMPTY_DOT) {
                pos = i;
            }
        }
        if (sum > sumOfAllFears && pos >= 0) {
            delta = array.length - 1 - pos;
            sumOfAllFears = sum;
            return true;
        }
        return false;
    }

    public static boolean isFound2(char[] array, char c) {
        for (char ch : array) {
            if (ch != c) return false;
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
            if (analyzeMap(HUMAN_DOT, IS_VICTORY)) {
                System.out.println("Победил игрок!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            if (!analyzeMap(AI_DOT, AI_DOTS_CHECK)) {
                analyzeMap(HUMAN_DOT, HUMAN_DOTS_CHECK);
            }
            aiTurn();
            printField();
            if (analyzeMap(AI_DOT, IS_VICTORY)) {
                System.out.println("Победил компьютер!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
            sumOfAllFears = 0;
        }
    }
}
