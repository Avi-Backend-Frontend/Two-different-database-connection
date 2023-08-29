package com.spring.multiple.ds.api.books.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Books {

	@Id
	private int book_id;
	private String name;
	private int price;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int book_id, String name, int price) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Books [book_id=" + book_id + ", name=" + name + ", price=" + price + "]";
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
