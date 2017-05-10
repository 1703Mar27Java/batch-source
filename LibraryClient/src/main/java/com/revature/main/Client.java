package com.revature.main;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;
import com.revature.service.Library;

public class Client {

	public static void main(String[] args) {

		String serviceUrl = "http://localhost:8086/LibraryService/Library";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceUrl);
		// set up interceptors to view soap messages
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));

		// consume the service!
		Library library = (Library) factory.create();
		List<Book> bookList = library.getAllBooks();
		for (Book temp : bookList) {
			System.out.println(temp);
		}

		// post request
		try {
			String response = library
					.addBook(new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", 1999));
			System.out.println(response);

		} catch (LibraryFullException e) {
			System.out.println(e.getMessage());
		}

	}

}
