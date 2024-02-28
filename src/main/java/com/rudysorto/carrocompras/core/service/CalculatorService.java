package com.rudysorto.carrocompras.core.service;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Interface used to define the method to calculate the total order
*/
public interface CalculatorService<T> extends  Service {
    double calculateTotalOrder(T orden);

}
