package lesson01.homework;

public class Homework1 {

    public static void main(String[] args) {
        int a = 3;
        int b = 6;
        int c = 18;
        int d = 4;
        System.out.println(doFirstTask(a, b, c, d));

        System.out.println(doSecondTask(a, b));
        System.out.println(doSecondTask(a, c));
        System.out.println(doSecondTask(b, d));

        doThirdTask(5);
        doThirdTask(0);
        doThirdTask(-5);

        doFourthTask("студент");

        doFifthTask(2020);
        doFifthTask(100);
        doFifthTask(48);
        doFifthTask(400);
        doFifthTask(500);
    }

    public static double doFirstTask(int a, int b, int c, int d){
        return a * (b + ((double)c / d));
    }

    public static boolean doSecondTask(int a, int b){
        int c = a + b;
        return c >= 10 && c <=20;
    }

    public static void doThirdTask(int a){
        if (a >= 0){
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    public static void doFourthTask(String name){
        System.out.println("Привет, " + name + "!");
    }

    public static void doFifthTask(int year){
        /*if (year % 4 != 0){
            System.out.println("Год " + year + " не является високосным");
        } else if (year % 400 == 0){
            System.out.println("Год " + year + " является високосным");
        } else if (year % 100 == 0){
            System.out.println("Год " + year + " не является високосным");
        } else{
            System.out.println("Год " + year + " является високосным");
        }*/

        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Год " + year + " является високосным");
        } else {
            System.out.println("Год " + year + " не является високосным");
        }
    }
}
