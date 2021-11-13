package com.pb.khantimerov.hw7;
/**
 * класс Atelier с методом main, и еще двумя статическими методами:
 * dressMan(Clothes[] clothes)
 * dressWomen(Clothes[] clothes)
 * на вход которых будет поступать массив, содержащий все типы одежды.
 * В методе main создать массив, содержащий все типы одежды, и
 * вызвать методы dressMan и dressWomen передав туда этот массив.
 * Метод dressWomen выводит на консоль всю информацию о женской одежде.
 * Метод dressMan выводит на консоль всю информацию о мужской одежде.
 * В методах dressWomen и dressMan использовать оператор instanceof
 * для определения мужская это одежда или женская.
 */

public class Atelier {
    public static void main(String[] args) {
        Size oneXS = Size.XS;
        Pants pants1 = new Pants();
        Skirt skirt1 = new Skirt();
        Tie tie1 = new Tie();
        Tshirt t1 = new Tshirt();

        System.out.println(oneXS.getEuroSize(oneXS));
        System.out.println(oneXS.getDescription(oneXS));


        Clothes[] clothes = new Clothes[] {pants1, skirt1, tie1, t1};

        for (Clothes clothe : clothes) {
            if (clothe instanceof Pants || clothe instanceof Tshirt) {
                clothe.dressMan();
            } else if (clothe instanceof Tie) {
                clothe.dressMan();
            } else if (clothe instanceof Skirt) {
                clothe.dressWoman();
            } else {
                System.out.println("Неизвестны тип одежды");
            }
        }
    }
}
