package com.pb.khantimerov.hw13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NewYearPresents {
    static volatile int childrenGifts = 0; // общее кол-во полученных подарков
    static volatile int personsGifts = 0; // общее кол-во подаренных подарков

    static class Children implements Runnable {
        private final List<String> buffer;
        private final String name;

        public Children(List<String> buffer, String name) {
            this.buffer = buffer;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized int fromSack (List<String> sack, String child) {
            int p = 0;  // кол-во подарков каждого ребенка
            int s = sack.size();
            String gift; // = null;
                try {
                    gift = sack.get(0);
                    if (s > 0) {
                        sack.remove(0);
                        System.out.println("-- " + name + " взял(а) " + gift + " из мешка :)");
                        p = 1;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(":( " + child + " :( Мешок пустой, нет подарков.");
                }
                return p;
        }

        public void run() {
            int i = 0, p = 0;
            while (i < 5) { // ребенок может проверить и получить подарок не больше 5 раз
                try {
                    int seconds = new Random().nextInt(5);
                    Thread.sleep(seconds * 1000);
                    p += fromSack(buffer, name);
                } catch (InterruptedException e) {
                    e.printStackTrace(); }
                i++;
            }
            System.out.println("\n***** " + name + " получил(а) " + p + " подарков *****\n");
            childrenGifts += p;
            }
    }

    static class Person implements Runnable {
        private final List<String> buffer;
        private final String present;

        public Person(List<String> buffer, String present) {
            this.buffer = buffer;
            this.present = present;
        }

        public synchronized int toSack (List<String> sack, String gift, String person) {
            int s = sack.size(), p = 0;
            if (s < 10) {  // персонаж может подарить только макс. 10 подарков
                sack.add(gift);
                p = 1;
                System.out.println("++ " + person + " положил(а) " + gift + " в мешок :)");
            } else {
                System.out.println("Мешок полон. Нельзя положить новый подарок :(");
            }
            return p;
        }

        public void run() {
            int i = 0, p = 0;
            String threadName = Thread.currentThread().getName();
            while (i < 10) {
                int seconds = new Random().nextInt(3);
                try {
                    Thread.sleep(seconds * 1000);
                    p += toSack(buffer, present, threadName);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            System.out.println("\n===== " + threadName + " положил(а) " + p + " подарков =====\n");
            personsGifts += p;
            //System.out.println(threadName + " Что в мешке? >> " + buffer);

        }
    }


    public static void main(String[] args) throws InterruptedException {
        List<String> sack = Collections.synchronizedList(new ArrayList<>());

        Thread ded = new Thread(new Person(sack, "конфеты"));
        Thread snegurochka = new Thread(new Person( sack, "печенье"));
        Thread santa = new Thread(new Person(sack, "тортик"));
        Thread baba = new Thread(new Person(sack, "жачку"));
        Thread niko = new Thread(new Person(sack, "шоколадку"));
        ded.setName("Дед Мороз");
        snegurochka.setName("Снегрочка");
        santa.setName("Санта Клаус");
        baba.setName("Баба яга");
        niko.setName("Святой Николай");


        Thread child1 = new Thread(new Children(sack, "Вовочка"));
        Thread child2 = new Thread(new Children(sack, "Петя"));
        Thread child3 = new Thread(new Children(sack, "Юля"));
        Thread child4 = new Thread(new Children(sack, "Филя"));
        Thread child5 = new Thread(new Children(sack, "Женя"));
        Thread child6 = new Thread(new Children(sack, "Саша"));
        Thread child7 = new Thread(new Children(sack, "Коля"));
        Thread child8 = new Thread(new Children(sack, "Герхард"));
        Thread child9 = new Thread(new Children(sack, "Олег"));
        Thread child10 = new Thread(new Children(sack, "Леша"));
//        child1.setName("Вовочка");
//        child2.setName("Петя");
//        child3.setName("Юля");
//        child4.setName("Филя");
//        child5.setName("Женя");
//        child6.setName("Саша");
//        child7.setName("Яша");
//        child8.setName("Коля");
//        child9.setName("Герхард");
//        child10.setName("Влад");


        ded.start();
        snegurochka.start();
        child1.start();
        child2.start();
        child3.start();
        santa.start();
        child4.start();
        child5.start();
        baba.start();
        niko.start();
        child6.start();
        child7.start();
        child8.start();
        child9.start();
        child10.start();

        TimeUnit.SECONDS.sleep(30);

        //wait all

        //  1 минуты хватает на отработку всех потоков при текущем кол-ве персонажей
        System.out.println("\n\n------------------------------------------------ " +
                "\nЗа 1 минуту персонажи подарили " + personsGifts + " подарков."
        + "\nДети получили " + childrenGifts + " подарков." +
                "\n------------------------------------------------\n");

        if (sack.size() > 0) {
            System.out.println("В мешке осталось: " + sack);
        } else {
            System.out.println("В мешке ничего не осталось :(");
        }
    }
}
