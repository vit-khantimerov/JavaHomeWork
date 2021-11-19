package com.pb.khantimerov.hw8;

import java.util.Objects;

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

    public void signUp (String login, String password, String confirmPassword)
        throws WrongLoginException {
            this.userLogin = login;
            if (Objects.equals(password, confirmPassword)) {
                System.out.println("\nПароль подтвержден.");
                this.userPassword = password;
            } else {
                this.userPassword = null;
                throw new WrongLoginException(password);
            }
    }

    public void signIn(String login, String password)
            throws WrongPasswordException {

        if (Objects.equals(login, userLogin) && Objects.equals(password, userPassword)) {
            System.out.println("\nДоступ разрешен.");
        } else {
            System.out.println("\nДоступ запрещен.\nНеверные логин и/или пароль.");
            throw new WrongPasswordException(password);
        }
    }
}
