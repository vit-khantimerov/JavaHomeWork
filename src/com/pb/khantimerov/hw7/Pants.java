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

    public Pants(String model, Size size, String color, int price, int length) {
        super(size, color, price);
        super.setType("брюки");
        this.length = length;
        this.model = model;
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
        System.out.println(type + ", модель - " + model + ", цвет - " + color + ", размер " + size +
                " (Евро № " + size.getEuroSize() + ", " + size.getDescription(size) +
                "), длина " + length + " см, цена - " + price + " грн.");
    }

    @Override
    public void dressWoman() {
        super.dressWoman();
        System.out.println(type + ", модель - " + model + ", цвет - " + color + ", размер " + size +
                " (Евро № " + size.getEuroSize() + ", " + size.getDescription(size) +
                "), длина " + length + " см, цена - " + price + " грн.");
    }
}