package com.pb.khantimerov.hw8;
/**
 * WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами
 * – один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.
 */

public class WrongLoginException extends Exception {
    private String signInPassword;

    public WrongLoginException(String signInPassword) {
        this.signInPassword = signInPassword;
    }
}
