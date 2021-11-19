package com.pb.chesnokov.hw8;

import java.util.Scanner;
import java.util.regex.Pattern;

public class OnlineShop {
    public static void main(String[] args) {
        Auth auth = new Auth();

        Scanner in = new Scanner(System.in);
        String login, password, confirmPassword;

        System.out.println("******** Регистрация ********");
        System.out.print("Введите логин: ");
        login = in.nextLine();
        System.out.print("Введите пароль: ");
        password = in.nextLine();
        System.out.print("Повторите пароль: ");
        confirmPassword = in.nextLine();

        try {
            auth.signUp(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }

        login = ""; password = "";
        System.out.println("******** Вход ********");
        System.out.print("Введите логин: ");
        login = in.nextLine();
        System.out.print("Введите пароль: ");
        password = in.nextLine();

        try {
            auth.signIn(login, password);
        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
