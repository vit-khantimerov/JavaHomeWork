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
        Pants firstPants = new Pants();

        System.out.println(oneXS.getEuroSize(oneXS));
        System.out.println(oneXS.getDescription(oneXS));
        firstPants.dressMan();
    }
}
