package com.pb.khantimerov.hw7;
/**
 * реализует интерфейс WomenClothes,
 */

public class Skirt extends Clothes  implements WomenClothes {
    int length;
    String fabric;

    public Skirt() {
        super();
        super.setType("юбка");
        fabric = "вельвет";
        length = 50;
    }

    public Skirt(String fabric, Size size, String color, int price, int length) {
        super(size, color, price);
        super.setType("юбка");
        this.length = length;
        this.fabric = fabric;
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
    public void getInfoWoman() {
        System.out.println(type + ", материал - " + fabric + ", цвет - " + color + ", размер " + size +
                " (Евро № " + size.getEuroSize() + ", " + size.getDescription(size) +
                "), длина " + length + " см, цена - " + price + " грн.");
    }
}