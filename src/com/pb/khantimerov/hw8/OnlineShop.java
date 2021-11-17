package com.pb.khantimerov.hw8;

import java.util.Scanner;

/**
 * +Создать класс OnlineShop с методом main.
 * +В main создать один объект класса Auth.
 * +Предложить пользователю сперва зарегистрироваться (signUp) потом войти на сайт (signIn).
 * Обработать исключения методов signUp signIn с помощью блоков try-catch.
 */

public class OnlineShop {
    public static void main(String[] args) {
        Auth user = new Auth();
        Scanner scan = new Scanner(System.in);
        String shopLogin, shopPassword, shopPassword2;


        System.out.println("Продите регистрацию в OnlineShop.\n\nВведите логин " +
                "\n(от 5 до 20 символов, только латинские буквы и цифры).");
        shopLogin = scan.nextLine();

        // дописать проверку на длину и допустимые символы {}

        System.out.println("Введите пароль \n(более 5 симолов, только латинские буквы, " +
                "цифры и знак подчеркивания)");
        shopPassword = scan.nextLine();

        // дописать проверку на длину и допустимые символы {}

        System.out.println("Повторите пароль.");
        shopPassword2 = scan.nextLine();

        user.signUp(shopLogin, shopPassword, shopPassword2);

        System.out.println("\nВход в OnlineShop.\nВведите логин...");
        shopLogin = scan.nextLine();

        System.out.println("Введите пароль...");
        shopPassword = scan.nextLine();

        user.signIn(shopLogin, shopPassword);
        System.out.println("User login - " + user.getUserLogin() + ", password - " + user.getUserPassword()
                + "\nUsed login - " + shopLogin + ", password - " + shopPassword);
    }
}
