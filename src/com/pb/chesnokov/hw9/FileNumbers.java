package com.pb.chesnokov.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.logging.*;

public class FileNumbers {

    private static final Logger LOGGER = Logger.getLogger(FileNumbers.class.getName());
    private static Path NUMFILE = Paths.get("numbersFile.txt");
    private static Path ODDNUMFILE = Paths.get("oddNumbersFile.txt");

    private static class MyFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            //return "[" + new SimpleDateFormat("dd:MM:yy HH:mm:ss").format(record.getMillis()) + "]" + " " + record.getLevel() + ": " + record.getMessage() + "\n";
            return record.getMessage() + "\n";
        }
    }

    private static void createNumbersFile() {
        int rand;
        try (BufferedWriter writer = Files.newBufferedWriter(NUMFILE)) {
            LOGGER.log(Level.INFO, "Создаем начальный файл (" + NUMFILE.getFileName() + ").");
            LOGGER.log(Level.INFO, "Заполняем начальный файл случайными числами...");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    rand = (int) (Math.random() * 100);
                    writer.write(rand + " ");
                }
                writer.newLine();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Ошибка создания файла " + NUMFILE.getFileName());
        }
    }

    private static void createOddNumbersFile() {
         try (
                BufferedReader reader = Files.newBufferedReader(NUMFILE);
                BufferedWriter writer = Files.newBufferedWriter(ODDNUMFILE)
            ) {
                String str;
                String[] intNums;
                LOGGER.log(Level.INFO, "Считваем файл " + NUMFILE.getFileName() + ", заменяем четные числа на 0 и записываем в файл " + ODDNUMFILE.getFileName());
                while ((str = reader.readLine()) != null) {
                    intNums = str.split(" ");
                    for (String intNum: intNums) {
                        if ((Integer.parseInt(intNum)) % 2 ==0)
                            writer.write("0 ");
                        else
                            writer.write(intNum + " ");
                    }
                    writer.newLine();
                }
            } catch (Exception ex) {
                LOGGER.log(Level.SEVERE, "Ошибка: " + ex.getMessage());
            }
    }

    private static void fileOutput(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String str, formatStr;
            String[] stringNums;

            LOGGER.log(Level.INFO, "Содержимое файла " + path.getFileName() + ":");
            while ((str = reader.readLine()) != null) {
                stringNums = str.split(" ");
                formatStr = "";
                for (String stringNum: stringNums) {
                    formatStr += String.format("%3d", Integer.parseInt(stringNum));
                    System.out.printf("%3d", Integer.parseInt(stringNum));
                }
                LOGGER.log(Level.FINE, formatStr);
                System.out.println();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Ошибка: " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception{
        FileHandler handler = new FileHandler("hw9-log.%u.%g.txt", 0, 3, false);
        handler.setFormatter(new MyFormatter());
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.ALL);
        LOGGER.setUseParentHandlers(false);

        createNumbersFile();
        createOddNumbersFile();
        System.out.println("---------- Первоначальный файл ----------");
        fileOutput(NUMFILE);
        System.out.println("---------- Файл после преобразования ----------");
        fileOutput(ODDNUMFILE);
    }
}
