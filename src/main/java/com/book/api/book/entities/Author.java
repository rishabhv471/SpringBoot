package com.book.api.book.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Author")
public class Author {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int author_id;
private String fname;
private String lname;
private String lang;

@OneToOne(mappedBy = "author")
@JsonBackReference
private Book book;

public Author() {
	super();
	// TODO Auto-generated constructor stub
}

public Author(int author_id, String fname, String lname, String lang) {
	super();
	this.author_id = author_id;
	this.fname = fname;
	this.lname = lname;
	this.lang = lang;
}


public int getAuthor_id() {
	return author_id;
}
public void setAuthor_id(int author_id) {
	this.author_id = author_id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getLang() {
	return lang;
}
public void setLang(String lang) {
	this.lang = lang;
}

public Book getBook() {
	return book;
}

public void setBook(Book book) {
	this.book = book;
}
}
