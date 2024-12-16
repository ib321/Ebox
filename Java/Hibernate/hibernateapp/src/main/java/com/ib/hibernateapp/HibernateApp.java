package com.ib.hibernateapp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ib.hibernateapp.model.Book;
import com.ib.hibernateapp.service.BookService;
import com.ib.hibernateapp.service.H2Server;

public class HibernateApp {

	public static void main(String[] args) throws SQLException {
		try {
			H2Server.startServer();
			BookService bookService = new BookService();
			Book book = new Book();
			book.setName("Hibernate for Beginners");
			book.setAuthor("John Doe");
			book.setCategory("Education");

			bookService.save(book);

			fetchAndPrintBooks(bookService);

			book.setName("Advanced Hibernate");
			bookService.update(book);

			fetchAndPrintBooks(bookService);

			bookService.delete(book);

			fetchAndPrintBooks(bookService);

			Scanner sc = new Scanner(System.in);
			System.out.println("waiting for input");
			sc.nextInt();
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			H2Server.stopServer();
		}
	}

	private static void fetchAndPrintBooks(BookService bookService) {
		List<Book> books = bookService.findAll();
		System.out.println("Books in the database:");
		for (Book b : books) {
			System.out.println("ID: " + b.getId() + ", Name: " + b.getName() + ", Author: " + b.getAuthor()
					+ ", Category: " + b.getCategory());
		}
	}
}
