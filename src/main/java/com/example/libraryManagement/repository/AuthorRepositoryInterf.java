package com.example.libraryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.libraryManagement.models.Author;

@Repository
public interface AuthorRepositoryInterf extends JpaRepository<Author,Integer>{

	Author findByEmail(String email);
	
	//Age>= , Country,name starting with
	
	//1st Option -> jpql query(we will use model names)
	//@Query("select * from Author a where a.age>=?1 and a.country=?2 and a.name like %?3")
	
	
	//2nd Option -> native query (we will use database names)
	//@Query("select * from author a where a.age>=?1 and a.country=?2 and a.name like %?3",native = true)

	//3rd Option -> writing JPA function
    //List<Author> findByAgeGreaterThanEqualAndCountryAndNameStartingWith(int age, String country, String prefix);

}
