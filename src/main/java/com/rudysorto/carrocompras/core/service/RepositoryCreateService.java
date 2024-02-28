package com.rudysorto.carrocompras.core.service;

import java.util.List;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: implementation ISP to define an interface that only create and show all data
*/
public interface RepositoryCreateService<T> extends Service {
	
	   List<T> getAll();
	   T create(T entity);
	   T save(T entity);

}
