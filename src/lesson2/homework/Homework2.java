package lesson2.homework;

//7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
//  при этом метод должен циклически сместить все элементы массива на n позиций.
//  [1,2,3,4,5], -2 => [3,4,5,1,2]
//  [1,2,3,4,5], 2 => [4,5,1,2,3]
//8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
public class Homework2 {

    public static void main(String[] args) {

        //1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        //  Написать метод, заменяющий в  принятом массиве 0 на 1, 1 на 0;
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        printArray(array1);
        printArray(getInverseArray(array1));

        //2 Задать пустой целочисленный массив размером 8.
        //  Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
        int[] array2 = new int[8];
        printArray(fillArray(array2));

        //3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
        //  написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(array3);
        printArray(modifyArray(array3));

        //4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
        int[] array4 = getRandomIntArray(10);
        printArray(array4);
        System.out.println("Минимальный элемент массива - " + getMin(array4));
        System.out.println("Максимальный элемент массива - " + getMax(array4));

        //5* Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
        //   заполнить его диагональные элементы единицами, используя цикл(ы);
        int size = 7;
        int[][] array5 = new int[size][size];
        int[][] resultArray = fillArraysDiagonal(array5);
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                System.out.print(resultArray[i][j] + "\t");
            }
            System.out.println();
        }

        //6** Написать метод, в который передается не пустой одномерный целочисленный массив
        //    метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
        int[] array6 = {6, 1, 2, 2, 2, 9};
        printArray(array6);
        System.out.println(checkBalance(array6));

        //7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным),
        //  при этом метод должен циклически сместить все элементы массива на n позиций.



    }

    //метод, заменяющий в  принятом массиве 0 на 1, 1 на 0
    public static int[] getInverseArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        return array;
    }

    //метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22
    public static int[] fillArray(int[] array) {
        int member = 1;
        int step = 3;
        for (int i = 0; i < array.length; i++) {
            array[i] = member;
            member += step;
        }
        return array;
    }

    //метод, принимающий на вход массив и умножающий числа меньше 6 на 2
    public static int[] modifyArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] < 6 ? array[i] * 2 : array[i];
        }
        return array;
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
    public static int[][] fillArraysDiagonal(int[][] array) {
        int lastIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            array[i][lastIndex - i] = 1;
            array[i][i] = 1;
        }
        return array;
    }

    //метод проверяющий баланс для массива
    public static boolean checkBalance(int[] array) {
        boolean isBalance = false;
        for (int i = 1; i < array.length - 1; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < i; j++) {
                sum1 += array[j];
            }
            for (int j = i; j < array.length; j++) {
                sum2 += array[j];
            }
            if (sum1 == sum2) {
                isBalance = true;
                break;
            }
        }
        return isBalance;
    }

    public static int[] getRandomIntArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        return array;
    }

    public static int[] getArrayFromConsole(int size) {
        int[] array = new int[size];
        return array;
    }

    public static void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + "\t");
        }
        System.out.println();
    }
}
