package com.omsarma.crud.controller;
import com.omsarma.crud.entity.BookDTO;
import com.omsarma.crud.response.ServerResponse;
import com.omsarma.crud.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.omsarma.crud.entity.Books;
import com.omsarma.crud.repo.BookRepository;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookController {


	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<ServerResponse> saveBook(@RequestBody @Valid BookDTO bookDto) {
		ServerResponse serverResponse = bookService.saveBook(bookDto);
		return new ResponseEntity<>(serverResponse, serverResponse.getStatus()) ;
	} 

	@GetMapping
	public ResponseEntity<ServerResponse> findAllBooks() {
		ServerResponse serverResponse = bookService.findAllBooks();
		return new ResponseEntity<>(serverResponse,serverResponse.getStatus());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ServerResponse> getBookById(@PathVariable Long id) {
		ServerResponse serverResponse = bookService.findByBookId(id);
		return new ResponseEntity<>(serverResponse, serverResponse.getStatus());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ServerResponse> updateBook(@PathVariable Long id,@RequestBody Books bookDetails) {
		ServerResponse serverResponse = bookService.updateBook(id, bookDetails);
		return new ResponseEntity<>(serverResponse, serverResponse.getStatus());

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ServerResponse> deleteBook(@PathVariable Long id) {
		ServerResponse serverResponse = bookService.deleteBookById(id);
		return new ResponseEntity<>(serverResponse, serverResponse.getStatus());

	}
	
}