package com.pb.khantimerov.hw7;
/**
 * реализует интерфейсы ManClothes и WomenClothes,
 */

public class Pants extends Clothes{
    int length;
    String model;

    public Pants() {
        super();
        model = "джинсы";
        length = 100;
        super.setType("брюки");
    }

    public Pants(String type, Size size, String color, int price, int length, String model) {
        super(type, size, color, price);
        this.length = length;
        this.model = model;
        super.setType("брюки");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void dressMan() {
        super.dressMan();
        System.out.println(type + ", тип - " + model + ", цвет - " + color + ", размер " + size +
                ", длина " + length + " см, цена - " + price + " грн.");
    }

    @Override
    public void dressWoman() {
        super.dressWoman();
        System.out.println(type + ", тип - " + model + ", цвет - " + color + ", размер " + size +
                ", длина " + length + " см, цена - " + price + " грн.");
    }
}