package com.pb.khantimerov.hw6;

import java.util.Objects;

/**
 * Dog, Cat, Horse переопределяют методы makeNoise, eat.
 * Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
 * В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.
 */
public class Cat  extends Animal {
    private String name, fur;

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat() {
        name = "Кот";
        fur = "короткая";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return Objects.equals(fur, cat.fur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fur);
    }

    @Override
    public String toString() {
        return "Кличка кота - " + getName() + ". Шерсть " + fur + ",\nпища - " + getFood() + ", место обитания - "
                + getLocation() + ".";
    }

    @Override
    public void makeNoise() {
        System.out.println(name + " издает звук \"мяяуу\".");
    }
}