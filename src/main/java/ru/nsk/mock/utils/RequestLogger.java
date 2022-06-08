package ru.nsk.mock.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Andrei Durkin <a.durkin@goodt.me>
 * @created 08.06.2022
 */

public class RequestLogger {

    private final static String EXT = ".txt";

    private final static String filename = getFileName();
    private static FileWriter fileWriter;

    static {
        try {
            fileWriter = new FileWriter(filename, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void log(String text, Object obj1, Object obj2) {
        final String message = String.format(text, obj1, obj2);
        fileWrite(message);
    }


    public synchronized static void log(String text) {
        fileWrite(text);
    }

    private static void fileWrite(String text) {
        try {
            fileWriter.write(text + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Cant write to log file" + e.getMessage());
        }
    }

    private static String getFileName() {
        String filename = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + " - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
        return filename.replace(":","") + EXT;
    }
}
