package com.pb.khantimerov.hw2;

import java.util.Scanner;

public class Interval {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number;

        System.out.println("Введите целое число, желательно от 0 до 100.");
        number = scan.nextInt();

        if(number < 0 || number > 100) {
            //  [0 -14] [15 - 35] [36 - 50] [51 - 100].
            System.out.println("Число не входит в диапазон от 0 до 100.");
        } else if(number >= 0 && number <= 14) {
            System.out.println("Число входит в диапазон от 0 до 14");
        } else if(number >= 15 && number <= 35) {
            System.out.println("Число не входит в диапазон от 15 до 35");
        } else if(number >= 36 && number <= 50) {
            System.out.println("Число не входит в диапазон от 36 до 50");
        } else if(number >= 51 && number <= 100) {
            System.out.println("Число не входит в диапазон от 51 до 100");
        }
    }
}
