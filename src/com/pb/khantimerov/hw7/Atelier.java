package com.pb.khantimerov.hw7;
/**
 * +класс Atelier с методом main, и еще двумя статическими методами:
 * +dressMan(Clothes[] clothes)
 * +dressWomen(Clothes[] clothes)
 * +на вход которых будет поступать массив, содержащий все типы одежды.
 * +В методе main создать массив, содержащий все типы одежды, и
 * +вызвать методы dressMan и dressWomen передав туда этот массив.
 * +Метод dressWomen выводит на консоль всю информацию о женской одежде.
 * +Метод dressMan выводит на консоль всю информацию о мужской одежде.
 * +В методах dressWomen и dressMan использовать оператор instanceof
 * +для определения мужская это одежда или женская.
 */
/*
   По условию ДЗ нет зарета на вывод одной и той же одежды дважды,
поэтому брюки и футболки печатаются дважды, т.к. в них не нет поля
"пол" и не проводится проверка по нему.
*/

public class Atelier {
    public static void main(String[] args) {
        Pants pants1 = new Pants();
        Pants pants2 = new Pants("штаны", Size.XXS, "белый", 500, 90);
        Skirt skirt1 = new Skirt();
        Skirt skirt2 = new Skirt("шелк", Size.S, "желтый", 200, 70);
        Tie tie1 = new Tie();
        Tie tie2 = new Tie("горошек", Size.M, "синий", 50, 50);
        Tshirt t1 = new Tshirt();
        Tshirt t2 = new Tshirt("поло", Size.XS, "оранжевый", 150, "длинный");

        Clothes[] clothes = new Clothes[] {pants1, skirt1, tie1, t1, pants2, skirt2, tie2, t2};

        dressMan(clothes);
        dressWoman(clothes);
    }

    static void dressMan (Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes clothe : clothes) {
            if (clothe instanceof Pants || clothe instanceof Tshirt || clothe instanceof Tie) {
                clothe.dressMan();
            }
        }
        System.out.println();
    }

    static void dressWoman (Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes clothe : clothes) {
            if (clothe instanceof Skirt || clothe instanceof Tshirt) {
                clothe.dressWoman();
            }
        }
        System.out.println();
    }
}

/* РЕЗУЛЬТАТ

Мужская одежда:
брюки, модель - джинсы, цвет - черный, размер XS (Евро № 34, взрослый размер), длина 100 см, цена - 100 грн.
галстук, рисунок - в полоску, цвет - черный, размер XS (Евро № 34, взрослый размер), длина 100 см, цена - 100 грн.
T-Shirt, модель - футболка, цвет - черный, размер XS (Евро № 34, взрослый размер), рукав короткий см, цена - 100 грн.
брюки, модель - штаны, цвет - белый, размер XXS (Евро № 32, детский размер), длина 90 см, цена - 500 грн.
галстук, рисунок - горошек, цвет - синий, размер M (Евро № 38, взрослый размер), длина 50 см, цена - 50 грн.
T-Shirt, модель - поло, цвет - оранжевый, размер XS (Евро № 34, взрослый размер), рукав длинный см, цена - 150 грн.

Женская одежда:
юбка, материал - вельвет, цвет - черный, размер XS (Евро № 34, взрослый размер), длина 50 см, цена - 100 грн.
T-Shirt, модель - футболка, цвет - черный, размер XS (Евро № 34, взрослый размер), рукав короткий см, цена - 100 грн.
юбка, материал - шелк, цвет - желтый, размер S (Евро № 36, взрослый размер), длина 70 см, цена - 200 грн.
T-Shirt, модель - поло, цвет - оранжевый, размер XS (Евро № 34, взрослый размер), рукав длинный см, цена - 150 грн.


Process finished with exit code 0

 */