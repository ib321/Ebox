package com.ib.springflex.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String author;
	private String category;
	
	public Book() {
		
	}

	public Book(int id, String name, String author, String category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.category = category;
	}

	public Book(String name, String author, String category) {
		super();
		this.name = name;
		this.author = author;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
