package com.pb.khantimerov.hw7;
/**
 * реализует интерфейсы ManClothes и WomenClothes,
 */

public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    String sleeve, model;

    public Tshirt() {
        super();
        super.setType("T-Shirt");
        sleeve = "короткий";
        model = "футболка";
    }

    public Tshirt(String model, Size size, String color, int price, String sleeve) {
        super(size, color, price);
        super.setType("T-Shirt");
        this.sleeve = sleeve;
        this.model = model;
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
    public void getInfo() {
        System.out.println(type + ", модель - " + model + ", цвет - " + color + ", размер " + size +
                " (Евро № " + size.getEuroSize() + ", " + size.getDescription(size) +
                "), рукав " + sleeve + " см, цена - " + price + " грн.");
    }
}
