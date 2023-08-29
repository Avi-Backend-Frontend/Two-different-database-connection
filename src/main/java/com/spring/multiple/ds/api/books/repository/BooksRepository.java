package com.spring.multiple.ds.api.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.multiple.ds.api.books.model.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Integer> {

}
