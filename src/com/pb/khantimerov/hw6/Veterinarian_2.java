
// https://github.com/anatoliy-shkabara-pb/
package com.pb.khantimerov.hw6;

/**
 * +класс Veterinarian (Ветеринар), в котором определите
 * +метод void treatAnimal(Animal animal):
 * +печатает на экран food и location пришедшего на прием животного.
 */
public class Veterinarian_2 {

    public static void treatAnimal_2(Animal animal) {
        System.out.println("Пришел " + animal.getSpecies() + " " + animal.getName() + ". Его пища " + animal.getFood() +
                ".\nТерритория обитания - " + animal.getLocation() + ".");
    }
}