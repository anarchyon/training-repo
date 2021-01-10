package lesson6.homework;

//1.Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
//2. Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
//3. * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
//4. ** Написать метод, проверяющий, есть ли указанное слово в папке

import java.io.*;
import java.util.Locale;
import java.util.logging.Filter;

public class Main {

    static TxtReader reader;

    public static void main(String[] args) {
        reader = new TxtReader();
        TxtWriter writer = new TxtWriter("text.txt");
        StringBuilder resultText = new StringBuilder();
        File[] files = {new File("text1.txt"), new File("text2.txt")};
        boolean isComplete = true;

        for (File file : files) {
            if (reader.readText(file)) {
                resultText.append(reader.getText()).append(System.lineSeparator());
            } else {
                System.out.println(reader.getError());
                isComplete = false;
            }
        }

        if (isComplete) {
            System.out.println(writer.writeText(resultText.toString()));
        } else {
            System.out.println("Не удалось склеить текстовые файлы.");
        }

        System.out.println("_________________");

        File fileForSearching = new File("text1.txt");
        String searchString = "У";
        search(fileForSearching, searchString);

        System.out.println("_________________");

        File file = new File("text1.txt");
        File dir = file.getAbsoluteFile().getParentFile();
        String extension = ".txt";
        files = dir.listFiles(new MyFileNameFilter(extension));
        searchString = "дуб";
        for(File f: files) {
            search(f, searchString);
        }
    }

    public static void search(File fileForSearching, String searchString) {
        System.out.printf("Поиск строки \"%s\" в файле \"%s\":%n", searchString, fileForSearching);
        if (reader.readText(fileForSearching)) {
            System.out.println(reader.findString(searchString));
        } else {
            System.out.println(reader.getError());
        }
    }
}
