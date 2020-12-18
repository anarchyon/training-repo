package lesson2.homework;

import java.util.Scanner;

public class Homework2 {

    public static void main(String[] args) {

        //1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        //  Написать метод, заменяющий в  принятом массиве 0 на 1, 1 на 0;
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(array1);
        getInverseArray(array1);
        printArray(array1);

        //2 Задать пустой целочисленный массив размером 8.
        //  Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
        int[] array2 = new int[8];
        fillArray(array2);
        printArray(array2);

        //3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        //  написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array3);
        modifyArray(array3);
        printArray(array3);

        //4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
        int[] array4 = getRandomIntArray(10);
        printArray(array4);
        System.out.println("Минимальный элемент массива - " + getMin(array4));
        System.out.println("Максимальный элемент массива - " + getMax(array4));

        //5* Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
        //   заполнить его диагональные элементы единицами, используя цикл(ы);
        int size = 7;
        int[][] array5 = new int[size][size];
        fillArraysDiagonal(array5);
        for (int i = 0; i < array5.length; i++) {
            for (int j = 0; j < array5[i].length; j++) {
                System.out.print(array5[i][j] + "\t");
            }
            System.out.println();
        }

        //6** Написать метод, в который передается не пустой одномерный целочисленный массив
        //    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
        int[] array6 = {6, 1, 2, 2, 2, 9};
        printArray(array6);
        System.out.println(checkBalance(array6));

        //7*** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
        //  при этом метод должен циклически сместить все элементы массива на n позиций.
        int[] array7 = getRandomIntArray(8);
        //int array7 = {1,2,3,4,5,6,7,8,9,10};
        int offsetSize = 2;
        printArray(array7);
        printArray(offsetArray(array7, offsetSize));

        //8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
        printArray(offsetArray2(array7, offsetSize));
    }

    //метод, заменяющий в  принятом массиве 0 на 1, 1 на 0
    public static void getInverseArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    //метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22
    public static void fillArray(int[] array) {
        int member = 1;
        int step = 3;
        for (int i = 0; i < array.length; i++) {
            array[i] = member;
            member += step;
        }
    }

    //метод, принимающий на вход массив и умножающий числа меньше 6 на 2
    public static void modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] < 6 ? array[i] * 2 : array[i];
        }
    }

    //метод поиска в массиве минимального элемента
    public static int getMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    //метод поиска в массиве максимального элемента
    public static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //метод для заполнения диагоналей масива
    public static void fillArraysDiagonal(int[][] array) {
        int lastIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            array[i][lastIndex - i] = 1;
            array[i][i] = 1;
        }
    }

    //метод проверяющий баланс для массива
    public static boolean checkBalance(int[] array) {
        int sum1 = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int sum2 = 0;
            sum1 += array[i];
            for (int j = i + 1; j < array.length; j++) {
                sum2 += array[j];
            }
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;
    }

    //метод смещает все элементы массива на n позиций со вспомогательным массивом
    public static int[] offsetArray(int[] array, int n) {
        if (n % array.length == 0) {
            return array;
        }
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int index = (i + n) % array.length;
            if (index < 0) {
                index += array.length;
            }
            resultArray[index] = array[i];
        }
        return resultArray;
    }

    //метод смещает все элементы массива на n позиций без вспомогательного массива
    public static int[] offsetArray2(int[] array, int n) {
        if (n % array.length == 0) {
            return array;
        }
        int oldIndex = 0;
        int temp1 = array[oldIndex];
        int temp2 = 0;
        for (int i = 0; i < array.length; i++) {
            //если размер массива и величина смещения чётные числа, то вручную сдвигаем индекс
            //после просмотра половины массива, иначе будем двигаться по одним и тем же индексам
            if (array.length % 2 == 0 && n % 2 == 0 && i == array.length / 2) {
                oldIndex++;
                temp1 = array[oldIndex];
            }
            //сам алгоритм нахождения старых/новых индексов такой же, как со вспомогательным массивом
            int newIndex = (oldIndex + n) % array.length;
            if (newIndex < 0) {
                newIndex += array.length;
            }
            //когда внесли элемент массива по новому индексу, этот новый индекс становится старым и ищем
            //относительно него, чтобы найти место для элемента, лежащего в переменной temp2
            temp2 = array[newIndex];
            array[newIndex] = temp1;
            oldIndex = newIndex;
            temp1 = temp2;
        }
        return array;
    }

    public static int[] getRandomIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return array;
    }

/*
    public static int[] getArrayFromConsole(int size) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[size];
        return array;
    }
*/

    public static void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
}
