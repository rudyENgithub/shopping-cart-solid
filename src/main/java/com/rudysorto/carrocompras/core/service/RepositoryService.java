package com.rudysorto.carrocompras.core.service;

import java.util.List;


/*
Author: Rudy Sorto rudy.eli.ayala@gmail.com
Objective: Interface used to apply LSP, ISP and define service with repository capability
*/
public interface RepositoryService<T> extends Service {
    List<T> getAll();

    T get(int id);

    T create(T entity);

    T save(int id, T entity);

    T delete(int id);


}

