package com.pb.chesnokov.hw8;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){

    }

    public WrongPasswordException(String ex) {
        super("Пароль: " + ex);
    }
}
