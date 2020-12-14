package lesson2.online;

public class Second {
    public static void main(String[] args) {

        printTablePifagor(6,4);
    }

    public static void printTablePifagor(int width, int heigth) {
        for (int i = 1; i <= heigth; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println("");
        }
    }
}
