package com.example.libraryManagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagement.enums.BookFilterType;
import com.example.libraryManagement.enums.BookSearchOperationType;
import com.example.libraryManagement.exception.InvalidIdException;
import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.requests.BookCreateRequest;
import com.example.libraryManagement.response.BookSearchResponse;
import com.example.libraryManagement.service.BookServiceInterf;

@RestController
public class BookController {

	@Autowired
	BookServiceInterf bookServiceInterf;
	
	@PostMapping(value="/saveBook")
	public ResponseEntity saveBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) {
		bookServiceInterf.create(bookCreateRequest);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping("/books/search")
	public List<BookSearchResponse> findBooks(@RequestParam("filter") BookFilterType bookFilterType,
			@RequestParam("value") String value){
		return bookServiceInterf.findFilteredBooks(bookFilterType, value);
	}
	
	@GetMapping("books/findById")
	public Book findBookById(@RequestParam("id") int id) {
		return bookServiceInterf.findById(id);
	}
	
	
	@DeleteMapping("books/deleteBook")
	public void deleteBook(@RequestParam("id") int id)throws InvalidIdException {
	      bookServiceInterf.deleteById(id);
	}
	
	
}
