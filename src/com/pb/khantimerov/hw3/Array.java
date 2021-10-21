package com.pb.khantimerov.hw3;

import java.util.Random;
import java.util.Arrays;

public class Array {

    public static void main (String[] args)  {

        int[] array = new int[10];
        Random random = new Random();
        int sumArray = 0, positive = 0;

        System.out.println ("Исходный массив:");

        for (int i = 0; i < array.length; i++) {    // формирование и печать массива
            array[i] = random.nextInt(201)-100;// рандом от -100 до 100
            sumArray = sumArray + array[i];

            if (i != (array.length - 1)) {
                System.out.print (array[i] + ", "); // вывод элементов массива кроме последнего
            } else {
                System.out.print (array[i]);        // вывод последнего элемента
            }

            if (array[i] > 0) {                     // сумма положительных элементов
                positive++;
            }
        }
        // статистика по исходнику
        System.out.println ("\n\nКоличество положительных элементов: " + positive);
        System.out.println ("Сумма элементов массива: " + sumArray);

        int count, tmp;                             // сортировка массива
        do { count = 0;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1])
                {
                    tmp = array[i];					//перестановка элементов массива
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    count++;
                }
            }
        }
        while (count > 0);

        System.out.println("\nОтсортированный массив: " + Arrays.toString(array));
    }
}