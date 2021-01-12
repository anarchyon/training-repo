package lesson6.homework;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TxtReader {

    private final String FILE_NOT_FOUND = "Ошибка! Файл \"%s\" не найден";
    private final String ERROR_IN = "Ошибка при попытке открыть файл \"%s\"";

    private String error;
    private StringBuilder text;

    TxtReader() {
    }

    public boolean readText(File file) {
        return readText(file.getAbsolutePath());
    }

    public boolean readText(String file) {
        text = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            int ch;
            while ((ch = isr.read()) != -1) {
                text.append((char) ch);
            }
            isr.close();
            fis.close();
        } catch (FileNotFoundException exception) {
            error = String.format(FILE_NOT_FOUND, file);
            return false;
        } catch (IOException e) {
            error = String.format(ERROR_IN, file);
            return false;
        }
        return true;
    }

    public StringBuilder getText() {
        return text;
    }

    public String getError() {
        return error;
    }

    //этот поиск оказался неполноценным
    public String findString(String searchString) {
        int pointer = 0;
        int count = 0;
        char[] text = this.text.toString().toLowerCase().toCharArray();
        char[] searchArr = searchString.toLowerCase().toCharArray();
        for(char c: text) {
            if (c == searchArr[pointer]) {
                pointer++;
                if (pointer == searchArr.length) {
                    count++;
                    pointer = 0;
                }
            } else {
                pointer = 0;
            }
        }
        return (count == 0) ? String.format("Строка \"%s\" не найдена", searchString) :
                String.format("Строка \"%s\" найдена, количество найденных: %s", searchString, count);
    }

    //более совершенный поиск, сам метод теперь не строит строку, т.к. это лишнее действие для него, метод ищет строку
    //и только возвращает количество найденных вхождений
    public int find(String searchString) {
        char[] text = this.text.toString().toLowerCase().toCharArray();
        char[] searchArr = searchString.toLowerCase().toCharArray();
        int count = 0;
        for (int i = 0; i <= text.length - searchArr.length; i++) {
            for (int j = 0; j < searchArr.length; j++) {
                if (text[i + j] != searchArr[j]) break;
                if (j == searchArr.length - 1) count++;
            }
        }
        return count;
    }
}
