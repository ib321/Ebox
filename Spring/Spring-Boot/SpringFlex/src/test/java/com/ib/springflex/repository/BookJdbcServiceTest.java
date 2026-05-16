package com.ib.springflex.repository;

import com.ib.springflex.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@TestPropertySource(locations = "classpath:application-test.properties")
public class BookJdbcServiceTest {

    @Autowired
    private BookJdbcService bookJdbcService;

    @BeforeEach
    public void setUp() {
        // Clear previous test data by deleting all books
        List<Book> books = bookJdbcService.fetchAllBooks();
        for (Book book : books) {
            bookJdbcService.deleteBook(book.getId());
        }
    }

    @Test
    public void testCreateBook() {
        Book book = new Book("Test Book", "Test Author", "Test Category");
        String result = bookJdbcService.createBook(book);

        assertEquals("Test Book", result);
    }

    @Test
    public void testCreateBookWithId() {
        Book book = new Book(1, "Book with ID", "Author", "Category");
        String result = bookJdbcService.createBook(book);

        assertEquals("Book with ID", result);
    }

    @Test
    public void testFetchAllBooks() {
        Book book1 = new Book("Book1", "Author1", "Category1");
        Book book2 = new Book("Book2", "Author2", "Category2");

        bookJdbcService.createBook(book1);
        bookJdbcService.createBook(book2);

        List<Book> books = bookJdbcService.fetchAllBooks();

        assertNotNull(books);
        assertTrue(books.size() >= 2);
    }

    @Test
    public void testFetchAllBooksEmpty() {
        List<Book> books = bookJdbcService.fetchAllBooks();
        assertNotNull(books);
    }

    @Test
    public void testUpdateBook() {
        Book book = new Book("Original Name", "Original Author", "Original Category");
        bookJdbcService.createBook(book);

        List<Book> books = bookJdbcService.fetchAllBooks();
        Book savedBook = books.get(books.size() - 1);

        savedBook.setName("Updated Name");
        savedBook.setAuthor("Updated Author");
        savedBook.setCategory("Updated Category");

        bookJdbcService.updateBook(savedBook);

        List<Book> updatedBooks = bookJdbcService.fetchAllBooks();
        Book retrievedBook = updatedBooks.stream()
            .filter(b -> b.getId() == savedBook.getId())
            .findFirst()
            .orElse(null);

        assertNotNull(retrievedBook);
        assertEquals("Updated Name", retrievedBook.getName());
        assertEquals("Updated Author", retrievedBook.getAuthor());
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("Book to Delete", "Author", "Category");
        bookJdbcService.createBook(book);

        List<Book> books = bookJdbcService.fetchAllBooks();
        int bookId = books.get(books.size() - 1).getId();

        bookJdbcService.deleteBook(bookId);

        List<Book> remainingBooks = bookJdbcService.fetchAllBooks();
        boolean exists = remainingBooks.stream()
            .anyMatch(b -> b.getId() == bookId);

        assertFalse(exists);
    }

    @Test
    public void testCreateBookSimple() {
        Book book = new Book(100, "Simple Book", "Simple Author", "Simple Category");
        int result = bookJdbcService.createBookSimple(book);

        assertEquals(100, result);
    }

    @Test
    public void testMultipleOperations() {
        // Create
        Book book1 = new Book("Book1", "Author1", "Category1");
        bookJdbcService.createBook(book1);

        // Read
        List<Book> books = bookJdbcService.fetchAllBooks();
        assertNotNull(books);
        assertTrue(books.size() >= 1);

        // Update
        if (!books.isEmpty()) {
            Book book = books.get(0);
            book.setName("Updated");
            bookJdbcService.updateBook(book);

            List<Book> updatedBooks = bookJdbcService.fetchAllBooks();
            assertTrue(updatedBooks.stream()
                .anyMatch(b -> "Updated".equals(b.getName())));
        }
    }

    @Test
    public void testBookWithSpecialCharacters() {
        Book book = new Book("Book's Name", "Author & Co.", "Technology/Science");
        String result = bookJdbcService.createBook(book);

        assertEquals("Book's Name", result);
    }

    @Test
    public void testUpdateNonExistentBook() {
        Book book = new Book(999, "Non Existent", "Author", "Category");
        // Should not throw exception
        bookJdbcService.updateBook(book);
    }
}

