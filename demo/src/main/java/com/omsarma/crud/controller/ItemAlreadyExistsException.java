package com.omsarma.crud.controller;

public class ItemAlreadyExistsException extends Exception{
    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
