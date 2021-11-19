package com.pb.khantimerov.hw8;

import java.util.Scanner;
import java.util.regex.Pattern;


public class OnlineShop {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        Auth user = new Auth();
        Scanner scan = new Scanner(System.in);
        String regLogin = null, regPassword = null, regPassword2 = null,
        userLogin = null, userPassword = null;
        int countLogin = 5, countPassword = 5;

        System.out.println("Пройдите регистрацию в OnlineShop.\n\nВведите логин " +
                "\n(от 5 до 20 символов, только латинские буквы и цифры)." +
                "\nУ Вас есть 5 попыток.");

    do {
        regLogin = scan.nextLine();
        if (Pattern.matches("[a-zA-Z0-9]{5,20}", regLogin)) {
            userLogin = regLogin;
            countLogin = 0;
        } else {
            countLogin--;
            if (countLogin > 0) {
                System.out.println("Неподходящий логин. Повторите попытку" +
                        "\n(от 5 до 20 символов, только латинские буквы и цифры).");
            }else{
                System.out.println("Это была последняя попытка :( ");
            }
        }
    } while (countLogin > 0);

        try {
            if (userLogin != null) {
                System.out.println("Введите пароль \n(более 5 симолов, только латинские буквы, " +
                        "цифры и знак подчеркивания _ )");

                do {
                    regPassword = scan.nextLine();
                    if (Pattern.matches("[a-zA-Z0-9_]{5,100}", regPassword)) {
                        userPassword = regPassword;
                        countPassword = 0;
                    } else {
                        countPassword--;
                        if (countPassword > 0) {
                            System.out.println("Неподходящий пароль. Повторите попытку.");
                            //regPassword = scan.nextLine();
                        } else {
                            System.out.println("Это была последняя попытка :( " +
                                    "\nПользователь не создан.");
                        }
                    }
                } while (countPassword > 0);
            }
            if (userPassword != null) {
                System.out.println("Повторите пароль.");
                regPassword2 = scan.nextLine();
                user.signUp(userLogin, regPassword, regPassword2);
            }

        } catch (WrongLoginException e) {
            e.printStackTrace();
            System.out.println("Пароль не подтвержден.");
            System.out.println("Пользователь не создан.");
            user = null;
        }

       // Вход произвоится вне зависимости от того, создан юзер или нет.

        System.out.println("\nВход в OnlineShop.\nВведите логин...");
        userLogin = scan.nextLine();

        System.out.println("Введите пароль...");
        userPassword = scan.nextLine();

        try {
            user.signIn(userLogin, userPassword);
        } catch (WrongPasswordException w) {
            //System.out.println("User login - " + user.getUserLogin() + ", password - " + user.getUserPassword()
            //        + "\nUsed login - " + userLogin + ", password - " + userPassword);
            w.printStackTrace();
        } catch (NullPointerException n) {
            System.out.println("\nДоступ запрещен.\nНеверные логин и/или пароль.");
            n.printStackTrace();
        }
        }
}

/* РЕЗУЛЬТАТ

Пройдите регистрацию в OnlineShop.

Введите логин
(от 5 до 20 символов, только латинские буквы и цифры).
У Вас есть 5 попыток.
1
Неподходящий логин. Повторите попытку
(от 5 до 20 символов, только латинские буквы и цифры).
oooo
Неподходящий логин. Повторите попытку
(от 5 до 20 символов, только латинские буквы и цифры).
lllll00000_____
Введите пароль
(более 5 симолов, только латинские буквы, цифры и знак подчеркивания _ )
p
Неподходящий пароль. Повторите попытку.
ppppp00000_____
Повторите пароль.
ppppp00000_____

Пароль подтвержден.

Вход в OnlineShop.
Введите логин...
lllll00000
Введите пароль...
ppppp00000_____

Доступ разрешен.

Process finished with exit code 0

 */