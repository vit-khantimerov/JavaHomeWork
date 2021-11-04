package com.pb.khantimerov.hw6;

/**
 * класс Veterinarian (Ветеринар), в котором определите
 * метод void treatAnimal(Animal animal):
 * печатает на экран food и location пришедшего на прием животного.
 */
public class Veterinarian {
    public static void main(String[] args) {
        Animal one = new Animal();
        Cat catOne = new Cat();
        catOne.setSpecies("кот");
        catOne.setFood("мыши");
        catOne.setLocation("дом");

        one.makeNoise();
        one.eat();
        one.sleep();
        treatAnimal(one);
        //System.out.println("Длина шерсти у " + catOne.getSpecies() + " " + catOne.getFur());
        System.out.println(catOne);
        System.out.println("Хеш-код " + catOne.hashCode());
        catOne.makeNoise();

    }

    public static void treatAnimal(Animal animal) {
        System.out.println("Пища " + animal.getSpecies() + " - " + animal.getFood() + ".");
        System.out.println("Территория обитания " + animal.getSpecies() + " - " + animal.getLocation() + ".");
    }
}

/*
Зверь издает звук "р-р-р-р".
Зверь ест.
Зверь спит.
Пища Зверь - трава.
Территория обитания Зверь - суша.
 */