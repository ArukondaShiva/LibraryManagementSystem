package com.example.libraryManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.libraryManagement.models.Author;
import com.example.libraryManagement.repository.AuthorRepositoryInterf;

@SpringBootApplication
public class LibraryManagementApplication implements CommandLineRunner{

	@Autowired
	AuthorRepositoryInterf authorRepositoryInterf;
	
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside Run");
		
//		List<Author> authorList = authorRepositoryInterf.findByAgeGreaterThanEqualAndCountryAndNameStartingWith(10,"India","p");
//		authorList.forEach(System.out::println);
		
	}	
	
}




