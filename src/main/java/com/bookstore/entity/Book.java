package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  // For auto increment
	private int id; // Primary key
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private String price;
	
	public Book(int id, String name, String author, String price) 
	{
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public Book()
	{
		super();
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	
}
