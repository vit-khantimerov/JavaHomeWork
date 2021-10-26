package com.pb.khantimerov.hw4;
import java.util.Scanner;
import java.util.Arrays;

public class Anagram {
// Программа сравнивает строки из букв (лат. и кир.) и цифр
// без учета регистра (Мир = РиМ).
        public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите текстовую строку.");
        String string_1 = scan.nextLine();
        System.out.println("Введите еще одну строку.");
        String string_2 = scan.nextLine();

        compareString (string_1, string_2);

    } // *** end public static void main ***

        public static void compareString (String str1, String str2) {
        String str_1, str_2;
        str_1 = str1.toLowerCase();
        str_2 = str2.toLowerCase();

        char[] array_1 = str_1.toCharArray();
        char[] array_2 = str_2.toCharArray();
        int numberLetters_1 = 0, numberLetters_2 = 0, equalLetters = 0;


        for (int i = 0; i < array_1.length; i++) {  // считаем буквы и цифры в первой строке
            if (Character.isLetter(array_1[i]) || Character.isDigit(array_1[i])) {
                numberLetters_1++;
            }
        }

        for (int i = 0; i < array_2.length; i++) {  // буквы и цифры во второй строке
            if (Character.isLetter(array_2[i]) || Character.isDigit(array_2[i])) {
                numberLetters_2++;
            }
        }

        if (numberLetters_1 != numberLetters_2) {
            System.out.println("Строки не являются анаграммами");
        } else {

            // заполняем массивы только из букв и цифр
            char[] array_1_Rebuilt = new char[numberLetters_1];
            char[] array_2_Rebuilt = new char[numberLetters_2];


            for (int i = 0, j = 0; i < array_1.length; i++) {
                if (Character.isLetter(array_1[i]) || Character.isDigit(array_1[i])) {
                    array_1_Rebuilt [j] = array_1[i];
                    j++;
                }
            }
            for (int i = 0, j = 0; i < array_2.length; i++) {
                if (Character.isLetter(array_2[i]) || Character.isDigit(array_2[i])) {
                    array_2_Rebuilt[j] = array_2[i];
                    j++;
                }
            }

            // сотрируем буквенно-цифровые массивы
            Arrays.sort(array_1_Rebuilt);
            Arrays.sort(array_2_Rebuilt);

            // сравниваем массивы
            for (int i = 0; i < numberLetters_1; i++) {
                if (array_1_Rebuilt[i] == array_2_Rebuilt[i]) {
                    equalLetters++;
                } else {
                    System.out.println("Строки не являются анаграммами");
                    break;
                }
            }
            if (equalLetters == numberLetters_1) {
                System.out.println("Строки являются анаграммами!");
            }
        }
    }
}