package com.book.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.api.book.dao.BookRepository;
import com.book.api.book.entities.Book;


@Service
public class bookService {
	@Autowired
	private BookRepository bookRepository;
//private static List<Book> list= new ArrayList<>();
//static {
//	list.add(new Book(12,"java","rishabh"));
//	list.add(new Book(24,"c++","rishabh"));
//	list.add(new Book(36,"python","rishabh"));
//}

public List<Book> getAllBooks()
{
	List<Book>list = (List<Book>) this.bookRepository.findAll();
	return list;
}
public Book getBookByIt(int it)
{
	Book book = null;
	//book=list.stream().filter(e->e.getIt()==it).findFirst().get();
	book = this.bookRepository.findById(it);
	return book;
}

public Book addBook(Book b)
{
	Book result = bookRepository.save(b);
	return result;
}
public void deleteBook(int it)
{
//	Book target = null;
	//target = list.stream().filter(e->e.getIt()==it).findFirst().get();
	bookRepository.deleteById(it);
	
}

public void updateBook(Book book, int it) {
//	list.stream().map(b -> {
//		if (b.getIt() == it) {
//			b.setTitle(book.getTitle());
//			b.setAuthor(book.getAuthor());
//		}
//		return b;
//	}).collect(Collectors.toList());
	book.setIt(it);
	bookRepository.save(book);
}
}

