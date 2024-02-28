package com.rudysorto.carrocompras.core.service;

import com.rudysorto.carrocompras.database.domain.User;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Interface used to define the methods for the user service
*/
public interface IUserService {

	public User findByUsername(String username);
}
