package com.rudysorto.carrocompras.core.service;

import java.util.List;

/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: implementation ISP to define an interface that only loads data
*/
public interface RepositoryLoadService<T> extends Service {
	List<T> getAll();
}
