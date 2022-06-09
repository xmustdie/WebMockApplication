package ru.nsk.mock.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            if (fileWriter == null) {
                fileWriter = new FileWriter(getFileName(), true);
            }
            fileWriter.write(text + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Cant write to log file " + e.getMessage());
        }
    }

    private static String getFileName() {
        String filePath = new File("").getAbsolutePath() + "\\logs\\";
        if (!Files.exists(Paths.get(filePath))) {
            System.out.println("CREATING LOGS DIRECTORY....");
            try {
                Files.createDirectory(Paths.get(filePath));
                System.out.println("SUCCESS !!!");
            } catch (IOException e) {
                System.out.println("Cant create logs directory " + e.getMessage());
            }
        }
        String filename = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + " - "
                + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).replace(":", "") + EXT;
        return filePath + filename;
    }
}
