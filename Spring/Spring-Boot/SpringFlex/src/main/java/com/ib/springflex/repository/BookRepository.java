package com.ib.springflex.repository;

import org.springframework.data.repository.CrudRepository;

import com.ib.springflex.model.Book;


public interface BookRepository extends CrudRepository<Book, Integer> {
}

