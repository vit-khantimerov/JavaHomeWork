/**
 * Реализовать параметризованный класс NumBox, T - параметр типа.
 * Параметром должен быть любой класс-наследник
 *     Number (задать необходимое условие при объявлении класса NumBox).
 */
package com.pb.khantimerov.hw10;

public class NumBox <T extends Number>{
    private final T[] numbers;
    private T[] number;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public void add(T number, int index) {
        this.numbers[index] = number;
        System.out.println(this.numbers[index].get());
    }

    public T get(int index) {
        return numbers[index];
    }

    public int length() {
        int length = 0;
        for (T t : numbers) {
            if (t != null) {
                length++;
            }
        }
        System.out.println(length);
        return length;
    }

    public double average() {
        double average = 0;
        int length = 0;
        for (T t : numbers) {
            if (t != null) {
                length++;
                average += t.get();
            }
        }
        //average = (float)average / length;
        System.out.println(average / length);

        return average / length;
    }

    public double sum() {
        double sum = 0;
        for (T t: numbers) {
            if (t != null) {
            sum += t.get();
            }
        }
        System.out.println(sum);
        return sum;
    }

    public T max() {
        double max, max0;
        int x = 0;
        while (numbers[x].get() == null) {
            x++;
        }
        max = numbers[x].get();

        for (int i = x, numbersLength = numbers.length; i < numbersLength; i++) {
            if (numbers[i] != null) {
                max = numbers[i].get();
            }
        }
        System.out.println("max " + numbers[x].get());
        return numbers[x];
    }
}
