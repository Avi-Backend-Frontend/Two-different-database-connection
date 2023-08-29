package com.spring.multiple.ds.api.authors.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "authorsDetails")
public class Authors {

	@Id
	private int author_id;
	private String name;
	private String address;
	
	public Authors() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Authors(int author_id, String name, String address) {
		super();
		this.author_id = author_id;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Authors [author_id=" + author_id + ", name=" + name + ", address=" + address + "]";
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
}
