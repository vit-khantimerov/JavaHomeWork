package com.pb.khantimerov.hw6;

/**
 * Класс Animal содержит переменные food, location и
 * методы makeNoise, eat, sleep.
 * Метод sleep, например, может выводить на консоль "Такое-то животное спит".
 */
public class Animal {
    private String species, food, location;

    public Animal(String species, String food, String location) {
        this.species = species;
        this.food = food;
        this.location = location;
    }

    public Animal() {
        species = "Зверь";
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
        System.out.println(species + " издает звук \"р-р-р-р\".");
    }

    public void eat() {
        System.out.println(species + " ест.");
    }

    public void sleep() {
        System.out.println(species + " спит.");
    }

}
