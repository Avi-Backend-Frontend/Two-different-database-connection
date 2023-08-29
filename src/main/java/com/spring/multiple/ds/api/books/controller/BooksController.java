package com.spring.multiple.ds.api.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.multiple.ds.api.books.model.Books;
import com.spring.multiple.ds.api.books.repository.BooksRepository;

@RestController
public class BooksController {

	@Autowired
	BooksRepository booksRepository;

	@GetMapping("/allBooks")
	List<Books> getBooks() {
		return booksRepository.findAll();
	}

	@PostMapping("/addBooks")
	public  Books addBooks(@RequestBody Books books) {
	return 	booksRepository.save(books);

	}
}
