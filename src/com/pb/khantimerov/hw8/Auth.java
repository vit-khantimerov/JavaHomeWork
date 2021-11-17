package com.pb.khantimerov.hw8;

import java.util.Objects;
import java.util.Scanner;

/**
 * +Создать класс Auth, который содержит поля login и password и методы:
 *
 * + signUp (регистрация на сайте) принимающий login, password, и confirmPassword.
 * Проверяет параметр login, длинна должна быть от 5 до 20 символов. Login должен содержать только латинские буквы и цифры. Если логин не соответствует требованиям нужно выбросить WrongLoginException.
 * Проверяет параметр password, длинна более 5, только латинские буквы и цифры и знак подчеркивания. Также password и confirmPassword должны совпадать. Если password не соответствует требованиям нужно выбросить WrongPasswordException.
 * Если проверки все пройдены успешно записать в свои поля значение login и password.
 * Так сохраняем пользователя :)
 *
 * + signIn (вход на сайт) принимающий login и password.
 * Проверяет что login и password соответствуют значениям из полей класса.
 * Если нет - выбрасывает исключение WrongLoginException.
 */

public class Auth {
    private String userLogin, userPassword;

    public Auth() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void signUp (String login, String password, String confirmPassword) {

        // дописать проверку на длину и допустимые символы {}
        this.userLogin = login;
        if (Objects.equals(password, confirmPassword)) {
            System.out.println("Пароль подтвержден.");
            this.userPassword = password;
        } else {
            System.out.println("Пароль не подтвержден.");
            this.userLogin = null;
            System.out.println("Пользователь не создан.");
        }
    }

    public void signIn(String login, String password) {

        // дописать проверку на длину и допустимые символы {}

        if (Objects.equals(login, userLogin) && Objects.equals(password, userPassword)) {
            System.out.println("Доступ разрешен.");
        } else {
            System.out.println("Неверные логин и/или пароль.");
        }
    }
}
