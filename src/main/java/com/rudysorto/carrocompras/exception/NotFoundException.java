package com.rudysorto.carrocompras.exception;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Exception created to handle when no data is found in the database query
*/
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
