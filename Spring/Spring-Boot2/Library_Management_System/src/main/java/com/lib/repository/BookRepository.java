package com.lib.repository;

import org.springframework.data.repository.CrudRepository;

import com.lib.model.Book;


/*
 * BookRepository interface extends the CrudRepository it will connect to the database
 */
public interface BookRepository extends CrudRepository<Book, Integer> {

}
