package com.pb.chesnokov.hw8;

public class WrongLoginException extends Exception{

    public WrongLoginException() {

    }

    public WrongLoginException(String ex) {
        super("Логин: " + ex);
    }
}
