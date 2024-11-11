package com.omsarma.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omsarma.crud.entity.Books;

import java.util.Optional;


public interface BookRepository extends JpaRepository<Books, Long> {

     Optional<Books> findByTitle(String title);

}
