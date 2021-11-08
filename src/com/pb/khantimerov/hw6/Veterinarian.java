
package com.pb.khantimerov.hw6;

/**
 * +класс Veterinarian (Ветеринар), в котором определите
 * +метод void treatAnimal(Animal animal):
 * +печатает на экран food и location пришедшего на прием животного.
 */
public class Veterinarian {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Veterinarian(String name) {
        this.name = name;
    }

    public Veterinarian() {
        name = "Дулитл";
    }

    public void treatAnimal(Animal animal) {
        System.out.println("Пришел " + animal.getSpecies() + " " + animal.getName() + ". Его пища " + animal.getFood() +
                ".\nТерритория обитания - " + animal.getLocation() + ".");
    }
    public void works (Veterinarian veterinarian) {
        System.out.println("Доктор " + veterinarian.getName() + " начинает прием.");
    }
}
