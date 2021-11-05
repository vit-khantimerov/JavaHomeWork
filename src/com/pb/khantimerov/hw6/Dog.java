package com.pb.khantimerov.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private String name, breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog() {
        name = "Снуп";
        breed = "лайка";
        setSpecies("пес");
        setFood("мясо");
        setLocation("двор");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed);
    }

    @Override
    public String toString() {
        return "Вид животного - " + getSpecies() + ", кличка - " + name + ", порода " + breed + ",\nпища - " + getFood()
                + ", место обитания - " + getLocation() + ".";
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака " + name + " лает.");
    }

    @Override
    public void eat() {
        System.out.println("Собака " + name + " ест.");
    }
}
