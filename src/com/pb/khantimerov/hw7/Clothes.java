package com.pb.khantimerov.hw7;
/**
 * абстрактный класс Clothes (одежда)
 * содержащий переменные размер (типа Size), стоимость, цвет.
 */

abstract class Clothes implements ManClothes, WomenClothes{
    Size size;
    String color;
    int price;

    public Clothes(Size size, String color, int price) {
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public Clothes() {
        size = Size.L;
        color = "черный";
        price = 100;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
