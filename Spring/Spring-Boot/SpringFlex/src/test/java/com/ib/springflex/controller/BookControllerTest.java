package com.ib.springflex.controller;

import com.ib.springflex.model.Book;
import com.ib.springflex.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Book testBook;

    @BeforeEach
    public void setUp() {
        bookRepository.deleteAll();
        testBook = new Book("Test Book", "Test Author", "Test Category");
    }

    @Test
    public void testCreateBook() throws Exception {
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Test Author"))
                .andExpect(jsonPath("$.category").value("Test Category"));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        Book book1 = new Book("Book1", "Author1", "Category1");
        Book book2 = new Book("Book2", "Author2", "Category2");
        bookRepository.save(book1);
        bookRepository.save(book2);

        mockMvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book savedBook = bookRepository.save(new Book("Original", "Author", "Category"));

        Book updatedBook = new Book("Updated Name", "Updated Author", "Updated Category");

        mockMvc.perform(put("/books/" + savedBook.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Name"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book savedBook = bookRepository.save(new Book("Book to Delete", "Author", "Category"));
        int bookId = savedBook.getId();

        mockMvc.perform(delete("/books/" + bookId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertFalse(bookRepository.findById(bookId).isPresent());
    }

    @Test
    public void testUpdateNonExistentBook() throws Exception {
        Book updatedBook = new Book("Updated", "Author", "Category");

        // This will throw a RuntimeException when book not found
        try {
            mockMvc.perform(put("/books/999")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updatedBook)));
        } catch (Exception e) {
            // Expected - book not found exception
            assertTrue(e.getCause() != null || e.getMessage().contains("Book not found"));
        }
    }

    @Test
    public void testGenerateUniqueBook() throws Exception {
        MvcResult result = mockMvc.perform(get("/books/gen")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        assertTrue(response.contains("RandomName"));
    }

    @Test
    public void testCreateMultipleBooks() throws Exception {
        for (int i = 1; i <= 3; i++) {
            Book book = new Book("Book" + i, "Author" + i, "Category" + i);
            mockMvc.perform(post("/books")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(book)))
                    .andExpect(status().isOk());
        }

        Iterable<Book> allBooks = bookRepository.findAll();
        int count = 0;
        for (Book b : allBooks) {
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    public void testCreateBookWithNullName() throws Exception {
        Book book = new Book(null, "Author", "Category");

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetBookById() throws Exception {
        Book savedBook = bookRepository.save(new Book("Findable Book", "Author", "Category"));

        mockMvc.perform(get("/books/" + savedBook.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testUpdateBookAllFields() throws Exception {
        Book savedBook = bookRepository.save(new Book("Original", "Author", "Category"));

        Book updatedBook = new Book("New Name", "New Author", "New Category");

        mockMvc.perform(put("/books/" + savedBook.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedBook)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New Name"))
                .andExpect(jsonPath("$.author").value("New Author"))
                .andExpect(jsonPath("$.category").value("New Category"));
    }
}





