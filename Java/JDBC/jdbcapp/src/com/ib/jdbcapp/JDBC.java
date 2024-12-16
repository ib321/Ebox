package com.ib.jdbcapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) {
        System.out.println("JDBC App Started");
        try {
            createData();
            fetchData();
            updateData();
            deleteData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeUpdate(String query) throws SQLException {
        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();

        int rowsAffected = statement.executeUpdate(query);
        System.out.println("Rows affected: " + rowsAffected);

        statement.close();
        connection.close();
    }

    public static void createData() throws SQLException {
        String query = "INSERT INTO book (id, name, author, category) VALUES (1, 'Book Title', 'Author Name', 'Category')";
        System.out.println("Executing createData()");
        executeUpdate(query);
    }

    public static void fetchData() throws SQLException {
        Connection connection = DBManager.getConnection();
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM book";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            System.out.println("ID: " + id + ", Name: " + name + ", Author: " + author + ", Category: " + category);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void updateData() throws SQLException {
        String query = "UPDATE book SET name = 'Updated Book Title' WHERE id = 1";
        System.out.println("Executing updateData()");
        executeUpdate(query);
    }

    public static void deleteData() throws SQLException {
        String query = "DELETE FROM book WHERE id = 1";
        System.out.println("Executing deleteData()");
        executeUpdate(query);
    }
}

class DBManager {
    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "system";
    private static final String PASSWORD = "ib321";

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
}
