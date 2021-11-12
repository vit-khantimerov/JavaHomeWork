package com.pb.khantimerov.hw7;
/**
 * реализует интерфейсы ManClothes и WomenClothes,
 */

public class Pants extends Clothes {
    int length;
    String type;

    public Pants() {
        type = "брюки";
        length = 100;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getToll() {
        return length;
    }

    public void setToll(int toll) {
        this.length = toll;
    }

    @Override
    public void dressMan() {
        super.dressMan();
        System.out.println("тип - " + type + ", цвет - " + color + ", размер " + size +
                ", длина " + length + "см, цена - " + price + " грн.");
    }
}
/*
    Size size;
    String color;
    float price;
    type = "брюки";
    length = 100;
 */