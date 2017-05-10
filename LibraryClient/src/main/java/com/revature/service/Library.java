package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;

@WebService
public interface Library {
	
	List<Book> getAllBooks();
	String addBook (Book book) throws LibraryFullException;

}
