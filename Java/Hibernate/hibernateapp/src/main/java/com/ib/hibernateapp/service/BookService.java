package com.ib.hibernateapp.service;
//package com.ib.hibernateapp.service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ib.hibernateapp.model.Book;

import java.util.List;

public class BookService {
	
	protected Session session;
	protected Transaction transaction;

	protected void startOperation() {
		session = HibernateUtil.getSessionFactory().openSession();
		//session = HibernateUtil2.getSessionFactory().openSession();
		transaction = session.beginTransaction();
	}

	protected void endOperation() {
		transaction.commit();
		session.close();
	}

    public void save(Book book) {
        try {
            startOperation();
            session.save(book);
            endOperation();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        try {
            startOperation();
            session.update(book);
            endOperation();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Book book) {
        try {
            startOperation();
            session.delete(book);
            endOperation();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Book findById(int id) {
        Book book = null;
        try {
            startOperation();
            book = session.get(Book.class, id);
            endOperation();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return book;
    }

    public List<Book> findAll() {
        List<Book> books = null;
        try {
            startOperation();
            Query query = session.createQuery("FROM Book");
            books = query.list();
            endOperation();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return books;
    }
}

