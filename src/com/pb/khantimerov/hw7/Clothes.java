package com.pb.khantimerov.hw7;
/**
 * абстрактный класс Clothes (одежда)
 * содержащий переменные размер (типа Size), стоимость, цвет.
 */

abstract class Clothes{
    String type;
    Size size;
    String color;
    int price;

    public Clothes(Size size, String color, int price) {
        type = "одежда";
        this.size = size;
        this.color = color;
        this.price = price;
    }

    public Clothes() {
        size = Size.XS;
        color = "черный";
        price = 100;
        type = "одежда";
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void getInfo() {
        System.out.println(type + ", цвет - " + color + ", размер " + size +
                " (Евро № " + size.getEuroSize() + ", " + size.getDescription(size) +
                "), цена - " + price + " грн.");
    }
}
