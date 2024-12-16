package com.ib.springflex.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.ib.springflex.model.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class BookJdbcService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createBookSimple(Book book) {
        String sql = "INSERT INTO book (id, name, author, category) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getId(), book.getName(), book.getAuthor(), book.getCategory());
        return book.getId();
    }
    
	public String createBook(Book book) {
		if (book.getId() != 0) {
			String sql = "INSERT INTO book (id, name, author, category) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, book.getId(), book.getName(), book.getAuthor(), book.getCategory());
		} else {
			String sql2 = "INSERT INTO book (name, author, category) VALUES (?, ?, ?)";
			jdbcTemplate.update(connection -> {
				PreparedStatement ps = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, book.getName());
				ps.setString(2, book.getAuthor());
				ps.setString(3, book.getCategory());
				return ps;
			});
		}
		return book.getName();
	}

    public List<Book> fetchAllBooks() {
        String sql = "SELECT * FROM book";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    public void updateBook(Book book) {
        String sql = "UPDATE book SET name = ?, author = ?, category = ? WHERE id = ?";
        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getCategory(), book.getId());
    }

    public void deleteBook(int id) {
        String sql = "DELETE FROM book WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class BookRowMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setName(rs.getString("name"));
            book.setAuthor(rs.getString("author"));
            book.setCategory(rs.getString("category"));
            return book;
        }
    }
}
