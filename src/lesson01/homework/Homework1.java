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

        int[] numbers = {5, 0, -4};
        for (int n: numbers) {
            System.out.println("Число " + n + ((isPositive(n))? " положительное" : " отрицательное"));
        }
//        isPositive(5);
//        isPositive(0);
//        isPositive(-5);

        System.out.println(greeting("студент"));

//        isLeapYear(2020);
//        isLeapYear(100);
//        isLeapYear(48);
//        isLeapYear(400);
//        isLeapYear(500);

        int[] years = {2020, 2021, 100, 48, 400, 500};
        for (int year: years){
            System.out.println("Год " + year + (isLeapYear(year) ? " вискокосный" : " не високосный"));
        }
    }

    public static double doFirstTask(int a, int b, int c, int d){
        return a * (b + ((double)c / d));
    }

    public static boolean doSecondTask(int a, int b){
        int c = a + b;
        return c >= 10 && c <=20;
    }

    public static boolean isPositive(int a){
        return a >= 0;
    }

    public static String greeting(String name){
        return "Привет, " + name + "!";
    }

    public static boolean isLeapYear(int year){
        /*if (year % 4 != 0){
            System.out.println("Год " + year + " не является високосным");
        } else if (year % 400 == 0){
            System.out.println("Год " + year + " является високосным");
        } else if (year % 100 == 0){
            System.out.println("Год " + year + " не является високосным");
        } else{
            System.out.println("Год " + year + " является високосным");
        }*/

//        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
//            System.out.println("Год " + year + " является високосным");
//        } else {
//            System.out.println("Год " + year + " не является високосным");
//        }
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
