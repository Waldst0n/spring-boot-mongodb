package com.waldstonsantana.mongodbspringboot.services.exceptions;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(String msg) {
        super(msg);
    }
}
