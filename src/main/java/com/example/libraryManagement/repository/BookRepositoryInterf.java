package com.example.libraryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryManagement.enums.BookSearchOperationType;
import com.example.libraryManagement.enums.Genre;
import com.example.libraryManagement.models.Author;
import com.example.libraryManagement.models.Book;

public interface BookRepositoryInterf extends JpaRepository<Book,Integer>{

	List<Book> findByName(String name);
	List<Book> findByAuthor_name(String authorName);
	List<Book> findByGenre(Genre genre);
	List<Book> findByCost(Integer cost);
	Book findByStudentId(int studentId);
	
//	List<Book> deleteById(Integer id);
	
	
}


//List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith(int age, String country, String prefix);