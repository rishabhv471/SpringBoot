package com.book.api.book.dao;
import org.springframework.data.repository.CrudRepository;

import com.book.api.book.entities.Book;
public interface BookRepository extends CrudRepository<Book, Integer> {
	
public Book findById(int id);
}
