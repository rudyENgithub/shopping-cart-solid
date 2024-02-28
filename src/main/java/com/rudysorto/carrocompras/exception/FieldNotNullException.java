package com.rudysorto.carrocompras.exception;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Exception created to handle when a data is not null in the dto data
*/
public class FieldNotNullException extends RuntimeException {
    public FieldNotNullException(String message) {
        super(message);
    }
}