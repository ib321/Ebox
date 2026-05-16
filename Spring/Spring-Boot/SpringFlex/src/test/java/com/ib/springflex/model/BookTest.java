package com.ib.springflex.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book();
    }

    @Test
    public void testBookNoArgsConstructor() {
        assertNotNull(book);
        assertEquals(0, book.getId());
        assertNull(book.getName());
        assertNull(book.getAuthor());
        assertNull(book.getCategory());
    }

    @Test
    public void testBookAllArgsConstructor() {
        Book book = new Book(1, "Test Book", "Test Author", "Fiction");
        assertEquals(1, book.getId());
        assertEquals("Test Book", book.getName());
        assertEquals("Test Author", book.getAuthor());
        assertEquals("Fiction", book.getCategory());
    }

    @Test
    public void testBookConstructorWithoutId() {
        Book book = new Book("Spring Guide", "John Doe", "Technology");
        assertEquals("Spring Guide", book.getName());
        assertEquals("John Doe", book.getAuthor());
        assertEquals("Technology", book.getCategory());
    }

    @Test
    public void testSetAndGetId() {
        book.setId(5);
        assertEquals(5, book.getId());
    }

    @Test
    public void testSetAndGetName() {
        book.setName("Java Programming");
        assertEquals("Java Programming", book.getName());
    }

    @Test
    public void testSetAndGetAuthor() {
        book.setAuthor("James Gosling");
        assertEquals("James Gosling", book.getAuthor());
    }

    @Test
    public void testSetAndGetCategory() {
        book.setCategory("Programming");
        assertEquals("Programming", book.getCategory());
    }

    @Test
    public void testBookWithAllFields() {
        book.setId(10);
        book.setName("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setCategory("Best Practices");

        assertEquals(10, book.getId());
        assertEquals("Effective Java", book.getName());
        assertEquals("Joshua Bloch", book.getAuthor());
        assertEquals("Best Practices", book.getCategory());
    }

    @Test
    public void testBookEquality() {
        Book book1 = new Book(1, "Book1", "Author1", "Category1");
        Book book2 = new Book(1, "Book1", "Author1", "Category1");

        assertEquals(book1.getId(), book2.getId());
        assertEquals(book1.getName(), book2.getName());
    }

    @Test
    public void testBookModification() {
        book.setId(1);
        book.setName("Original Name");
        book.setAuthor("Original Author");
        book.setCategory("Original Category");

        book.setName("Modified Name");
        book.setAuthor("Modified Author");
        book.setCategory("Modified Category");

        assertEquals("Modified Name", book.getName());
        assertEquals("Modified Author", book.getAuthor());
        assertEquals("Modified Category", book.getCategory());
    }
}

