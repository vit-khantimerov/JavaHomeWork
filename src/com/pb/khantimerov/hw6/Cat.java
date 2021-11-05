package com.pb.khantimerov.hw6;

import java.util.Objects;

/**
 * + Dog, Cat, Horse переопределяют методы makeNoise, eat.
 * + Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
 * - В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.
 */
public class Cat extends Animal {
    private String name, hair;
    private String picture =
            " /\\_/\\\n" +
            "( o.o )\n" +
            " > ^ < ";


    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat() {
        name = "Котяра";
        hair = "короткая";
        setSpecies("кот");
        setFood("мыши");
        setLocation("дом");
        picture =
                " /\\_/\\\n" +
                "( o.o )\n" +
                " > ^ < ";
    }

    public String getPicture() {
        return picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(hair, cat.hair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hair);
    }

    @Override
    public String toString() {
        // добавить поля животных
        return "Вид животного - " + getSpecies() + ", кличка - " + name + ", шерсть " + hair + ",\nпища - "
                + getFood() + ", место обитания - " + getLocation() + ".\n" + picture;
    }

    @Override
    public void makeNoise() {
        System.out.println("Кот " + name + " мяяяууукает.");
    }
    
    @Override
    public void eat() {
        System.out.println("Кот " + name + " ест.");
    }

}