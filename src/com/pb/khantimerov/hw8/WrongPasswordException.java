package com.pb.khantimerov.hw8;
/**
 * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами
 * – один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.
 */

public class WrongPasswordException extends Exception {
    private String signUpPassword;

    public WrongPasswordException(String signUpPassword) {
        this.signUpPassword = signUpPassword;
    }
}
