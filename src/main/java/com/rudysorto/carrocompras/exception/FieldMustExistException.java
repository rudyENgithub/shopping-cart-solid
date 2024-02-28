package com.rudysorto.carrocompras.exception;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Exception created to handle when a data must exist in dto data 
*/
public class FieldMustExistException extends RuntimeException {
    public FieldMustExistException(String message) {
        super(message);
    }
}

