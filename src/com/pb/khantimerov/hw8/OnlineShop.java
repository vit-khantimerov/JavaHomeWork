package com.pb.khantimerov.hw8;
/**
 * Создать класс OnlineShop с методом main.
 * В main создать один объект класса Auth.
 * Предложить пользователю сперва зарегистрироваться (signUp) потом войти на сайт (signIn).
 * Обработать исключения методов signUp signIn с помощью блоков try-catch.
 */

public class OnlineShop {
    public static void main(String[] args) {
        Auth user = new Auth();

        user.signUp();
        user.signIn();
    }
}
