package com.darashuk.spring.rest.exeption_handler;

public class NoSuchEmployeeExeption extends RuntimeException{
    public NoSuchEmployeeExeption(String message) {
        super(message);
    }
}
