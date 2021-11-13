package com.pb.khantimerov.hw7;
/**
 * реализует интерфейсы ManClothes и WomenClothes,
 */

public class Tshirt extends Clothes {
    String sleeve, model;

    public Tshirt() {
        super();
        sleeve = "короткий";
        model = "футболка";
        super.setType("T-Shirt");
    }

    public Tshirt(String type, Size size, String color, int price, String sleeve, String type1) {
        super(type, size, color, price);
        this.sleeve = sleeve;
        this.model = type1;
        super.setType("T-Shirt");
    }



    public String getSleeve() {
        return sleeve;
    }

    public void setSleeve(String sleeve) {
        this.sleeve = sleeve;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void dressMan() {
        super.dressMan();
        System.out.println(type + ", тип - " + model + ", цвет - " + color + ", размер " + size +
                ", рукав " + sleeve + " см, цена - " + price + " грн.");
    }

    @Override
    public void dressWoman() {
        super.dressWoman();
        System.out.println(type + ", тип - " + model + ", цвет - " + color + ", размер " + size +
                ", рукав " + sleeve + " см, цена - " + price + " грн.");
    }
}
