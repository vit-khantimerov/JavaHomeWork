package com.pb.khantimerov.hw10;

public class NumBox <T extends Number>{
    private final T[] numbers;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        numbers = (T[]) new Number[size];
    }

    public void add(T number, int index) {
        try {
            this.numbers[index] = number;
            System.out.println("Добавлен " + number.getClass().getSimpleName() + "[" + index + "] = " + this.numbers[index].get());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(number.getClass().getSimpleName() + "[" + index + "] не добален. Превышена длина массива.");
        }
    }

    public T get(int index) {
        try {
            System.out.println(numbers.getClass().getSimpleName() + " [" + index + "] = " + numbers[index].get());
            return numbers[index];
        } catch (NullPointerException e) {
            System.out.println(numbers.getClass().getSimpleName() + " [" + index + "] " + "Не заолнен.");
            return numbers[index];
        }
    }

    public int length() {
        int length = 0;
        for (T t : numbers) {
            if (t != null) {
                length++;
            }
        }
        System.out.println("Длина массива  = " + length);
        return length;
    }

    public Double average() {
        Double average = null;
        int length = 0;
        try {
            for (T t : numbers) {
                if (t != null) {
                    if (average == null) {
                        average = 0.0;
                    }
                    length++;
                    average += t.get();
                }
            }
            System.out.println("Среднее = " + average / length);
            average = average / length;
        } catch (NullPointerException e) {
            System.out.println("Среднее на посчитано.");
            average = null;
        }
        return average;
    }

    public Double sum() {
        Double sum = null;
        for (T t: numbers) {
            if (t != null) {
                if (sum == null) {
                    sum = 0.0;
                }
            sum += t.get();
            }
        }
        System.out.println("Сумма = " + sum);
        return (Double) sum;
    }

    public T max() {
        Double max = null;
        int x = 0;
        //do
        while (numbers[x] == null && x < numbers.length-1) {
            x++;
        }
        if (numbers[x] != null) {
            max = numbers[x].get();
        }

            for (int i = x; i < numbers.length; i++) {
                if (numbers[i] != null) {
                    if (numbers[i].get() > max) {
                        max = numbers[i].get();
                        x = i;
                    }
                }
            }
        System.out.println("Максимум = " + max);
        return numbers[x];
    }
}
