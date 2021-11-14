package com.pb.khantimerov.hw7;
/**
 * реализует интерфейс ManClothes.
 */

public class Tie extends Clothes implements ManClothes {
    int length;
    String design;

    public Tie() {
        super();
        super.setType("галстук");
        design = "в полоску";
        length = 100;
    }

    public Tie(String design, Size size, String color, int price, int length) {
        super(size, color, price);
        super.setType("галстук");
        this.length = length;
        this.design = design;
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
    public void getInfoMan() {
        System.out.println(type + ", рисунок - " + design + ", цвет - " + color + ", размер " + size +
                " (Евро № " + size.getEuroSize() + ", " + size.getDescription(size) +
                "), длина " + length + " см, цена - " + price + " грн.");
    }
}
