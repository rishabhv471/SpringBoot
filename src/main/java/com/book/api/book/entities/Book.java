package com.book.api.book.entities;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int it;
private String title;

@OneToOne(cascade=CascadeType.ALL)
@JsonManagedReference
private Author author;
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(int it, String title, Author author) {
	super();
	this.it = it;
	this.title = title;
	this.author = author;
}
public int getIt() {
	return it;
}
public void setIt(int it) {
	this.it = it;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}
@Override
public String toString() {
	return "Book [it=" + it + ", title=" + title + ", author=" + author + "]";
}


}
