package com.example.libraryManagement.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryManagement.models.Author;
import com.example.libraryManagement.repository.AuthorRepositoryInterf;
import com.example.libraryManagement.response.AuthorSearchResponse;
import com.example.libraryManagement.service.AuthorServiceInterf;

@Service
public class AuthorServiceImpl implements AuthorServiceInterf {

	@Autowired
	AuthorRepositoryInterf authorRepositoryInterf;
	
	@Override
	public Author createAuthor(Author author) {
		authorRepositoryInterf.save(author); 
		return author;
	}

	@Override
	public AuthorSearchResponse findAuthorResponseFromAuthor (String email){
		 
		Author author= findByEmail(email);
		return AuthorSearchResponse.builder()
				.id(author.getId())
				.age(author.getAge())
				.name(author.getName())
				.email(author.getEmail())
				.country(author.getCountry())
				.createdOn(author.getCreatedOn())
				.updatedOn(author.getUpdatedOn())
				.bookList(author.getBookList())
				.build();
	}
 

	@Override
	public Author findByEmail(String email) {
		return authorRepositoryInterf.findByEmail(email) ;
	}

}
