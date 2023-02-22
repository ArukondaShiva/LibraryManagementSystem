package com.example.libraryManagement.service;

import com.example.libraryManagement.models.Author;
import com.example.libraryManagement.response.AuthorSearchResponse;
 
public interface AuthorServiceInterf {

	Author createAuthor(Author author);
	
	Author findByEmail(String email);
	
	AuthorSearchResponse findAuthorResponseFromAuthor(String email);
	
}
