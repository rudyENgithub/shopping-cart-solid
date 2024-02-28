package com.rudysorto.carrocompras.exception;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Exception created to handle when a data is already in the database
*/
public class AllReadyException extends RuntimeException {
    public AllReadyException(String message) {
        super(message);
    }
}

