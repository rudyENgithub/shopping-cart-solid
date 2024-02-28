package com.rudysorto.carrocompras.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rudysorto.carrocompras.database.domain.User;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: interface used to access the data of the users table through the different methods it has
*/
public interface IUserDAO extends JpaRepository<User, Integer>   {
	
	public User findByUsername(String username);

}
