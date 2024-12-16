package com.ib.springflex.controller;

import com.ib.springflex.model.Book;
import com.ib.springflex.repository.BookJdbcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbcbooks")
public class BookJdbcController {

	@Autowired
	private BookJdbcService bookJdbcService;

	@PostMapping
	public String createBook(@RequestBody Book book) {
		return bookJdbcService.createBook(book);
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookJdbcService.fetchAllBooks();
	}

	@PutMapping("/{id}")
	public void updateBook(@PathVariable int id, @RequestBody Book book) {
		book.setId(id);
		bookJdbcService.updateBook(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable int id) {
		bookJdbcService.deleteBook(id);
	}

	@GetMapping(path = "/gen")
	public String generateUniqueBook() {
		int bookId = (int) (Math.random() * 1000);
		String Name = "RandomName" + bookId;
		Book uniqueBook = new Book(Name, "Author" + bookId, bookId + "Cat");
		return bookJdbcService.createBook(uniqueBook);
	}
}
