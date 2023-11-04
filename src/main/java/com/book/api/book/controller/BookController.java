package com.book.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.api.book.entities.Book;
import com.book.api.book.services.bookService;

@RestController
public class BookController {
	@Autowired
	private bookService BookService;
	
	
	//@RequestMapping(value="/books",method = RequestMethod.GET)
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		
		return BookService.getAllBooks();
	}
	
	@GetMapping("/books/{it}")
		public Book getBook(@PathVariable("it") int it)
		{
			return BookService.getBookByIt(it);
		}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book){
		Book b = this.BookService.addBook(book);
		System.out.println(book);
		return b;
		
	}
	@DeleteMapping("/books/{it}")
	public void deleteBook(@PathVariable("it") int it)
	{
		 this.BookService.deleteBook(it);
	}
	@PutMapping("/books/{it}")
	public Book updateBook(@RequestBody Book book ,@PathVariable("it")int it)
	{
		this.BookService.updateBook(book,it);
		return book;
	}
	
}
