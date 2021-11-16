package com.pb.khantimerov.hw8;
/**
 * Создать класс Auth, который содержит поля login и password и методы:
 *
 * - signUp (регистрация на сайте) принимающий login, password, и confirmPassword.
 * Проверяет параметр login, длинна должна быть от 5 до 20 символов. Login должен содержать только латинские буквы и цифры. Если логин не соответствует требованиям нужно выбросить WrongLoginException.
 * Проверяет параметр password, длинна более 5, только латинские буквы и цифры и знак подчеркивания. Также password и confirmPassword должны совпадать. Если password не соответствует требованиям нужно выбросить WrongPasswordException.
 * Если проверки все пройдены успешно записать в свои поля значение login и password. Так сохраняем пользователя :)
 *
 * - signIn (вход на сайт) принимающий login и password.
 * Проверяет что login и password соответствуют значениям из полей класса.
 * Если нет - выбрасывает исключение WrongLoginException.
 */

public class Auth {
    public void signUp () {
    }

    public void signIn() {

    }
}
