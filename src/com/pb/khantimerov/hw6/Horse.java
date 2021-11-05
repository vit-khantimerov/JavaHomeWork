package com.pb.khantimerov.hw6;

import java.util.Objects;

public class Horse extends Animal {
        private String name, maxSpeed;

        public String getMaxSpeed() {
            return maxSpeed;
        }

        public void setHair(String maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Horse() {
            name = "Скрипт";
            maxSpeed = "50 км/ч";
            setSpecies("конь");
            setFood("трава");
            setLocation("степь");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Horse horse = (Horse) o;
            return Objects.equals(maxSpeed, horse.maxSpeed);
        }

        @Override
        public int hashCode() {
            return Objects.hash(maxSpeed);
        }

        @Override
        public String toString() {
            return "Вид животного - " + getSpecies() + ", кличка - " + name + ", макс. скорость " + maxSpeed + "," +
                    "\nпища - " + getFood() + ", место обитания - " + getLocation() + ".";
        }

        @Override
        public void makeNoise() {
            System.out.println("Конь " + name + " ржет.");
        }

        @Override
        public void eat() {
            System.out.println("Конь " + name + " ест.");
        }
    }