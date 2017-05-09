package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library {

	@Override
	public List<Book> getAllBooks() {
		System.out.println("getAllBooks");
		List<Book> bookList = new ArrayList<>();
		//we should be getting books from a backend. But we're not. 
		bookList.add(new Book("Moby Dick","Herman Melville",1851));
		bookList.add(new Book("The Fellowship of the Ring","J.R.R. Tolkien",1954));
		bookList.add(new Book("The Art of War","Sun Tzu",1521));
		return bookList;
	}

	@Override
	public String addBook(Book book) throws LibraryFullException {
		System.out.println("add book: "+book);
		if (book.getYear() == 1999){
			throw new LibraryFullException("Library full. Cannot add book: "+book);
		}
		return "Successfully added book with title: "+book.getTitle();
	}

}
