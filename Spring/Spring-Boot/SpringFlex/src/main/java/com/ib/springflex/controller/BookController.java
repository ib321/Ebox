package com.ib.springflex.controller;

import com.ib.springflex.model.Book;
import com.ib.springflex.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	// Create a new book
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	// Get all books
	@GetMapping
	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	// Update a book
	@PutMapping("/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
		Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		book.setName(bookDetails.getName());
		book.setAuthor(bookDetails.getAuthor());
		book.setCategory(bookDetails.getCategory());
		return bookRepository.save(book);
	}

	// Delete a book
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable int id) {
		bookRepository.deleteById(id);
	}

	@GetMapping("/gen")
	public String generateUniqueBook() {
		int bookId = (int) (Math.random() * 1000);
		String Name = bookId + "RandomName";
		Book uniqueBook = new Book(Name, bookId + "Author", bookId + "Cat");
		return bookRepository.save(uniqueBook).getName();
	}
}
