package com.example.libraryManagement.service;

import java.util.List;

import com.example.libraryManagement.enums.BookFilterType;
import com.example.libraryManagement.enums.BookSearchOperationType;
import com.example.libraryManagement.exception.InvalidIdException;
import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.requests.BookCreateRequest;
import com.example.libraryManagement.response.BookSearchResponse;

public interface BookServiceInterf {

	Book create(BookCreateRequest bookCeateRequest);
	
	Book save(Book book);
	
	Book findById(Integer id);
	
    public List<BookSearchResponse> findFilteredBooks(BookFilterType bookFilterType, String value);
	
	void deleteById(int id)throws InvalidIdException;
	
}




//public List<BookSearchResponse> findRobustFilteredBooks(BookFilterType bookFilterType, String value,
//BookSearchOperationType bookSearchOperationType);

//List<Book> find(BookFilterType bookFilterType, String value);

//add update and delete Methods