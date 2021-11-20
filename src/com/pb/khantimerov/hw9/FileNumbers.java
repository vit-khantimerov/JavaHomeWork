package com.pb.khantimerov.hw9;

import java.util.Random;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNumbers {
    public static void main(String[] args) throws Exception {

        int size = 100; // кол-во случаных чисел
        String nrFilePath = "C:/Users/HP/IdeaProjects/JavaHomeWork/" +
                "src/com/pb/khantimerov/hw9/numbers.txt";
        String oddPath = "C:/Users/HP/IdeaProjects/JavaHomeWork/" +
                "src/com/pb/khantimerov/hw9/odd-numbers.txt";

        int[] array = new int[size]; // исходный массив
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((size-1)) + 1;
        }

        createNumbersFile(array, nrFilePath);
        createOddNumbersFile(nrFilePath, oddPath, size);
    }

    public static void createNumbersFile(int [] Array, String file) {
        printToFile_x10(Array, file);
    }

    public static void createOddNumbersFile(String file, String oddFile, int size) {
        Path path = Paths.get(file);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String lineFull = " ", line;
            while((line = reader.readLine()) != null) {
                lineFull = String.join(" ", lineFull, line);
            }

            int[] oddArray = toNumArray(lineFull, size);

            printToFile_x10(oddArray, oddFile);

        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
    }

    private static int[] toNumArray(String line, int size) { // конвертация строки в числовой массив
        String [] split = line.split(" ");

        int[] intArr = new int[size];
        int x = 0;

        for (String s : split) {
            if (!s.equals("")) {
                intArr[x] = Integer.parseInt(s);
                if (intArr[x] % 2 == 0) {
                    intArr[x] = 0;
                }
                x++;
            }
        }
        return intArr;
    }

    private static void printToFile_x10(int [] Array, String file) { // печать в файл по 10 чисел в строку
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))) {
            for (int i = 0; i < Array.length; i++) {
            writer.write(String.valueOf(Array[i]));
            if ((i + 1) % 10 == 0) {
                writer.write("\n");
            } else {
                writer.write(" ");
            }
        }
        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
    }
}