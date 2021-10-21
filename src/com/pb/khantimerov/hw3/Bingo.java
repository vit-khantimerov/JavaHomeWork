package com.pb.khantimerov.hw3;

import java.util.Random;
import java.util.Scanner;

public class Bingo {
    public static void main (String[] args) {

        int randomNumber, userNumber, countAttempts = 0;
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        randomNumber = random.nextInt(101);// рандом от 0 до 100
        // System.out.println(randomNumber); // служебный вывод задуманного числа

        System.out.println("Введите целое число от 0 до 100 и нажмите Enter \n(если захотите закончить досрочно, введите 741)");
        do {
            countAttempts++;
            if (countAttempts!=1) {
            System.out.println("\nПопытка " + (countAttempts));
            }
            userNumber = scan.nextInt();
            if (userNumber == 741) {
                userNumber = randomNumber;
                System.out.println("Вы не угадали :(");
            }

            if (userNumber < randomNumber) {
                System.out.println("Ваше число меньше задуманного."); }
            else if (userNumber > randomNumber) {
                System.out.println("Ваше число больше задуманного.");
            }

            if (userNumber < 0 || userNumber > 100) {
                System.out.println("*** Вводите только целые числа от 0 до 100 ***");
            }
        }
        while (userNumber != randomNumber);

        System.out.println("Игра окончена.  Было загадано число " + randomNumber + "." + "\nКоличество попыток: " + countAttempts + ".");
    }
}
