package com.spring.multiple.ds.api.authors.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.multiple.ds.api.authors.model.Authors;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Integer> {

}
