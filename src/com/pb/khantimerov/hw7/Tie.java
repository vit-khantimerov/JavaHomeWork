package com.pb.khantimerov.hw7;
/**
 * реализует интерфейс ManClothes.
 */

public class Tie extends Clothes {
    int length;
    String design;

    public Tie() {
        super();
        design = "в полоску";
        length = 100;
        super.setType("галстук");
    }

    public Tie(String type, Size size, String color, int price, int length, String design) {
        super(type, size, color, price);
        this.length = length;
        this.design = design;
        super.setType("галстук");
    }

    public String getDesign() {
        return design;
    }

    public void setType(String design) {
        this.design = design;
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
        System.out.println(type + ", рисунок - " + design + ", цвет - " + color + ", размер " + size +
                ", длина " + length + " см, цена - " + price + " грн.");
    }
}
