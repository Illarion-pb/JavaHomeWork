package com.pb.chesnokov.hw8;

import javax.print.attribute.standard.MediaSize;
import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;

    public void signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        if (!(Pattern.matches("[a-zA-Z0-9]{5,20}", login))) {
            if (!(Pattern.matches("[a-zA-Z0-9]+", login)))
                throw new WrongLoginException("Поле содержит неразрешенный символ.");
            else
                throw new WrongLoginException("Поле должно содержать от 5 до 20 символов.");
        }


        if (!(Pattern.matches("\\w{5,}", password)))
            if (!(Pattern.matches("\\w+", password)))
                throw new WrongPasswordException("Поле содержит неразрешенный символ.");
            else
                throw new WrongPasswordException("Поле должно содержать более 5 символов.");
        else
            if (!password.equals(confirmPassword))
                throw new WrongPasswordException("Поля не совпадают");

        this.login = login;
        this.password = password;
        System.out.println("Регистрация успешна!");
    }

    public void signIn(String login, String password) throws WrongLoginException, WrongPasswordException{
        if (this.login == null || this.password == null) {
            throw new WrongLoginException("Пользователь не зарегестрирован.");
        }
        if (this.login.equals(login))
            if (this.password.equals(password))
                System.out.println("Авторизация успешна");
            else
                throw new WrongPasswordException("Неверный пароль.");
        else
            throw new WrongLoginException("Неверный логин.");
        System.out.println("Вход успешный!");
    }
}
