package com.ib.springflex.controller;

import com.ib.springflex.model.Book;
import com.ib.springflex.repository.BookJdbcService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookJdbcControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookJdbcService bookJdbcService;

    @Autowired
    private ObjectMapper objectMapper;

    private Book testBook;

    @BeforeEach
    public void setUp() {
        // Clear all books
        List<Book> books = bookJdbcService.fetchAllBooks();
        for (Book book : books) {
            bookJdbcService.deleteBook(book.getId());
        }
        testBook = new Book("JDBC Test Book", "JDBC Author", "JDBC Category");
    }

    @Test
    public void testCreateBook() throws Exception {
        mockMvc.perform(post("/jdbcbooks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testBook)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllBooks() throws Exception {
        Book book1 = new Book("Book1", "Author1", "Category1");
        Book book2 = new Book("Book2", "Author2", "Category2");
        bookJdbcService.createBook(book1);
        bookJdbcService.createBook(book2);

        mockMvc.perform(get("/jdbcbooks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book savedBook = new Book("Original", "Author", "Category");
        bookJdbcService.createBook(savedBook);
        
        List<Book> books = bookJdbcService.fetchAllBooks();
        int bookId = books.get(0).getId();
        
        Book updatedBook = new Book("Updated Name", "Updated Author", "Updated Category");

        mockMvc.perform(put("/jdbcbooks/" + bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = new Book("Book to Delete", "Author", "Category");
        bookJdbcService.createBook(book);
        
        List<Book> books = bookJdbcService.fetchAllBooks();
        int bookId = books.get(0).getId();

        mockMvc.perform(delete("/jdbcbooks/" + bookId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        List<Book> remainingBooks = bookJdbcService.fetchAllBooks();
        boolean exists = remainingBooks.stream()
            .anyMatch(b -> b.getId() == bookId);
        assertFalse(exists);
    }

    @Test
    public void testGenerateUniqueBook() throws Exception {
        MvcResult result = mockMvc.perform(get("/jdbcbooks/gen")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertTrue(response.contains("RandomName"));
    }

    @Test
    public void testCreateMultipleBooks() throws Exception {
        for (int i = 1; i <= 3; i++) {
            Book book = new Book("JdbcBook" + i, "JdbcAuthor" + i, "JdbcCategory" + i);
            mockMvc.perform(post("/jdbcbooks")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(book)))
                    .andExpect(status().isOk());
        }

        List<Book> allBooks = bookJdbcService.fetchAllBooks();
        assertTrue(allBooks.size() >= 3);
    }

    @Test
    public void testCreateBookWithSpecialCharacters() throws Exception {
        Book book = new Book("Book's Title", "Author & Co.", "Tech/Science");

        mockMvc.perform(post("/jdbcbooks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllBooksEmpty() throws Exception {
        mockMvc.perform(get("/jdbcbooks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMultipleFields() throws Exception {
        Book book = new Book("Original Title", "Original Author", "Original Category");
        bookJdbcService.createBook(book);
        
        List<Book> books = bookJdbcService.fetchAllBooks();
        int bookId = books.get(0).getId();
        
        Book updatedBook = new Book("New Title", "New Author", "New Category");

        mockMvc.perform(put("/jdbcbooks/" + bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isOk());

        List<Book> updated = bookJdbcService.fetchAllBooks();
        Book retrievedBook = updated.stream()
            .filter(b -> b.getId() == bookId)
            .findFirst()
            .orElse(null);
        
        assertNotNull(retrievedBook);
        assertEquals("New Title", retrievedBook.getName());
    }
}

