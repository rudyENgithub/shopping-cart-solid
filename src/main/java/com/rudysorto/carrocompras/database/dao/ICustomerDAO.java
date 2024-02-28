package com.rudysorto.carrocompras.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rudysorto.carrocompras.database.domain.Customer;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: interface used to access the data of the customers table through the different methods it has
*/
public interface ICustomerDAO extends JpaRepository<Customer, Integer>   {

}
