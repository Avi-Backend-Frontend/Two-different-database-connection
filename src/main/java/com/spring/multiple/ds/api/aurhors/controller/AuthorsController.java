package com.spring.multiple.ds.api.aurhors.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.multiple.ds.api.authors.model.Authors;
import com.spring.multiple.ds.api.authors.repository.AuthorsRepository;

@RestController
public class AuthorsController {

	@Autowired
	AuthorsRepository authorsRepository;

	@GetMapping("/allAuthors")
	List<Authors> getAuthors() {
		return authorsRepository.findAll();
	}

	@PostMapping("/addAuthors")
	public Authors addBooks(@RequestBody Authors authors) {
		return authorsRepository.save(authors);

	}

}
