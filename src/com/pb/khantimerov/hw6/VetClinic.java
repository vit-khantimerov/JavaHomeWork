package com.pb.khantimerov.hw6;
import java.lang.reflect.Constructor;

import static com.pb.khantimerov.hw6.Veterinarian.*;

/**
 * +Создайте класс VetСlinic в его методе main создайте массив типа Animal,
 * +в который запишите животных всех имеющихся у вас типов.
 * +В цикле отправляйте животных на прием к ветеринару.
 * +Объект класса Veterinarian создайте с помощью рефлексии.
 */
public class VetClinic {
    public static void main(String[] args) throws Exception {
        Veterinarian vet = new Veterinarian();

        Class clazz = vet.getClass();

        Class vetClazz = Class.forName("com.pb.khantimerov.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor(new Class[] {String.class});
        Object obj = constr.newInstance("Айболит");
        if (obj instanceof Veterinarian) {
            ((Veterinarian) obj).works((Veterinarian) obj);
        } else {
            vet.works(vet);
        }
        System.out.println();

        Animal animal = new Animal();
        Cat cat = new Cat();
        Dog dog = new Dog();
        Horse horse = new Horse();

        Animal[] animals = new Animal[]{animal, cat, dog, horse};

        for (Animal a : animals) {
            vet.treatAnimal(a);
            a.makeNoise();
            System.out.println();
        }

        System.out.println(cat.getPicture());
    }
}
