package com.rudysorto.carrocompras.exception;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Exception created to handle when a field is not empty in the dto data
*/
public class FieldNotEmptyException extends RuntimeException {
    public FieldNotEmptyException(String message) {
        super(message);
    }
}
