package com.ib.springflex.repository;

import com.ib.springflex.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository bookRepository;

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book("Spring in Action", "Craig Walls", "Spring Framework");
        entityManager.persistAndFlush(book);
    }

    @Test
    public void testFindById() {
        Book foundBook = bookRepository.findById(book.getId()).orElse(null);
        assertNotNull(foundBook);
        assertEquals("Spring in Action", foundBook.getName());
        assertEquals("Craig Walls", foundBook.getAuthor());
    }

    @Test
    public void testSaveBook() {
        Book newBook = new Book("Clean Code", "Robert C. Martin", "Programming");
        Book savedBook = bookRepository.save(newBook);

        assertNotNull(savedBook.getId());
        assertEquals("Clean Code", savedBook.getName());
    }

    @Test
    public void testUpdateBook() {
        book.setName("Updated Spring in Action");
        book.setAuthor("Updated Author");

        Book updatedBook = bookRepository.save(book);

        assertEquals("Updated Spring in Action", updatedBook.getName());
        assertEquals("Updated Author", updatedBook.getAuthor());
    }

    @Test
    public void testDeleteBook() {
        int bookId = book.getId();
        bookRepository.delete(book);

        assertFalse(bookRepository.findById(bookId).isPresent());
    }

    @Test
    public void testFindAll() {
        Book anotherBook = new Book("Effective Java", "Joshua Bloch", "Best Practices");
        bookRepository.save(anotherBook);

        Iterable<Book> books = bookRepository.findAll();
        assertNotNull(books);

        int count = 0;
        for (Book b : books) {
            count++;
        }
        assertTrue(count >= 2);
    }

    @Test
    public void testBookNotFound() {
        assertFalse(bookRepository.findById(999).isPresent());
    }

    @Test
    public void testSaveMultipleBooks() {
        Book book1 = new Book("Book1", "Author1", "Category1");
        Book book2 = new Book("Book2", "Author2", "Category2");

        Book saved1 = bookRepository.save(book1);
        Book saved2 = bookRepository.save(book2);

        assertNotNull(saved1.getId());
        assertNotNull(saved2.getId());
        assertNotEquals(saved1.getId(), saved2.getId());
    }

    @Test
    public void testDeleteById() {
        int bookId = book.getId();
        bookRepository.deleteById(bookId);

        assertFalse(bookRepository.findById(bookId).isPresent());
    }

    @Test
    public void testExistsById() {
        assertTrue(bookRepository.existsById(book.getId()));
        assertFalse(bookRepository.existsById(999));
    }

    @Test
    public void testCount() {
        long count = bookRepository.count();
        assertTrue(count >= 1);
    }
}

