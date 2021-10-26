package com.pb.khantimerov.hw4;
import java.util.Scanner;

// Считаем, что новое слово начинается ТОЛЬКО после пробела.
public class CapitalLetter {
        public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        String stringCapital;

        System.out.println("Введите текстовую строку и нажмите Enter.");
        String stringIn = scan.nextLine();

        //String stringIn = "Истина — это то, что выдерживает проверку опытом. Эйнштейн А.";

        stringCapital = FirstCapitalLetter (stringIn);
        System.out.println("Преобразованная строка:\n" + stringCapital);

    } // *** end public static void main ***

    public static String FirstCapitalLetter (String str) {
        String strCapital;
        char[] array_1 = str.toCharArray();
        array_1[0] = Character.toUpperCase(array_1[0]); // начало строки - в верхний регистр

        for (int i = 0; i < array_1.length-1; i++) {
            if (array_1 [i] == ' ') { // || array_1 [i] == ',' || array_1 [i] == '.') {
                array_1[i+1] = Character.toUpperCase(array_1[i+1]);
            }
        }

        strCapital = new String (array_1);
        return strCapital;
    }
}