package lesson6.homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TxtWriter {

    private final String ERROR_OUT = "Ошибка при попытке открыть файл %s на запись";
    private final String WRITE_OK = "Файл \'%s\' успешно записан";

    private final String filePath;

    TxtWriter(String filePath) {
        this.filePath = filePath;
    }

    public String writeText(String stringForWrite) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            PrintStream ps = new PrintStream(fos);
            ps.println(stringForWrite);
            ps.close();
            fos.close();
        } catch (IOException e) {
            return String.format(ERROR_OUT, filePath);
        }
        return String.format(WRITE_OK, filePath);
    }
}
