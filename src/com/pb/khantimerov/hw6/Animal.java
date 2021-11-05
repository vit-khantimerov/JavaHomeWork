package com.pb.khantimerov.hw6;

import java.util.Objects;

/**
 * + Класс Animal содержит переменные food, location и
 * + методы makeNoise, eat, sleep.
 * + Метод sleep, например, может выводить на консоль "Такое-то животное спит".
 */
public class Animal {
    private String species, food, location, name;

    public Animal(String name, String species, String food, String location) {
        this.name = name;
        this.species = species;
        this.food = food;
        this.location = location;
    }

    public Animal() {
        name = "Альфа";
        species = "зверь";
        food = "трава";
        location = "суша";
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFood() {
        return food;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise() {
        System.out.println(species + " " + name + " издает звук \"р-р-р-р\".");
    }

    public void eat() {
        System.out.println(species + " ест.");
    }

    public void sleep() {
        System.out.println(species + " спит.");
    }
}
