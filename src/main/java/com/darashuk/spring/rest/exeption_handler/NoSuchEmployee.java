package com.darashuk.spring.rest.exeption_handler;

public class NoSuchEmployee extends RuntimeException{
    public NoSuchEmployee(String message) {
        super(message);
    }
}
