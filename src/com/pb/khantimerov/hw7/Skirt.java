package com.pb.khantimerov.hw7;
/**
 * реализует интерфейс WomenClothes,
 */

public class Skirt extends Clothes {
    int length;
    String fabric;

    public Skirt() {
        super();
        fabric = "вельвет";
        length = 50;
        super.setType("юбка");
    }

    public Skirt(String type, Size size, String color, int price, int length, String fabric) {
        super(type, size, color, price);
        this.length = length;
        this.fabric = fabric;
        super.setType("юбка");
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String type) {
        this.fabric = type;
    }

    public int getLength() {
        return length;
    }

    public void setToll(int length) {
        this.length = length;
    }

    @Override
    public void dressWoman() {
        super.dressWoman();
        System.out.println(type + ", материал - " + fabric + ", цвет - " + color + ", размер " + size +
                ", длина " + length + " см, цена - " + price + " грн.");
    }
}
