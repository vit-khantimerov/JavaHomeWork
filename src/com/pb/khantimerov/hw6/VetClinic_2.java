package com.pb.khantimerov.hw6;

import java.lang.reflect.Constructor;

import static com.pb.khantimerov.hw6.Veterinarian_2.*;
import static com.pb.khantimerov.hw6.Veterinarian.*;

/**
 * +Создайте класс VetСlinic в его методе main создайте массив типа Animal,
 * +в который запишите животных всех имеющихся у вас типов.
 * +В цикле отправляйте животных на прием к ветеринару.
 * +Объект класса Veterinarian создайте с помощью рефлексии.
 */
public class VetClinic_2 {
    public static void main(String[] args) throws Exception {
        Veterinarian_2 vet_2 = new Veterinarian_2();
        Veterinarian vet_0 = new Veterinarian();

        Class clazz_2 = vet_2.getClass();

        Class vetClazz_2 = Class.forName("com.pb.khantimerov.hw6.Veterinarian");
        System.out.println("vetClazz_2 = " + vetClazz_2);
        Object obj_2 = vetClazz_2.newInstance();
        Object obj_x = vet_2.getClass().newInstance();
        Object obj_0 = vet_0.getClass().newInstance();
        if (obj_2 instanceof Veterinarian_2) {
            System.out.println("class of obj_2 is " + obj_2.getClass());
        }

        if (obj_2 instanceof Veterinarian_2) {
            System.out.println("class of obj_x is " + obj_x.getClass());
        }
            System.out.println("class of obj_0 is " + obj_0.getClass());
        System.out.println();


        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Horse horse = new Horse();

        Animal[] animals = new Animal[]{animal, cat, dog, horse};

        for (Animal a : animals) {
            treatAnimal_2(a);
            a.makeNoise();
            System.out.println();
        }

        System.out.println(cat.getPicture());
        System.out.println();

        Object [] anys = new Object[animals.length];
        int i;
        for (i = 0; i < animals.length; i++) {
            anys[i] = animals[i].getClass().newInstance();
            System.out.println("class of anys[" + i + "] is " + anys[i].getClass());
        }
    }
}
/*
vetClazz_2 = class com.pb.khantimerov.hw6.Veterinarian
class of obj_0 is class com.pb.khantimerov.hw6.Veterinarian

Пришел зверь Альфа. Его пища трава.
Территория обитания - суша.
зверь Альфа издает звук "р-р-р-р".

Пришел кот Котяра. Его пища мыши.
Территория обитания - дом.
Кот Котяра мяяяууукает.

Пришел пес Снуп. Его пища мясо.
Территория обитания - двор.
Собака Снуп лает.

Пришел конь Скрипт. Его пища трава.
Территория обитания - степь.
Конь Скрипт ржет.

 /\_/\
( o.o )
 > ^ <

class of anys[0] is class com.pb.khantimerov.hw6.Animal
class of anys[1] is class com.pb.khantimerov.hw6.Cat
class of anys[2] is class com.pb.khantimerov.hw6.Dog
class of anys[3] is class com.pb.khantimerov.hw6.Horse

Process finished with exit code 0

 */
