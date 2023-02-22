package com.example.libraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libraryManagement.response.AuthorSearchResponse;
import com.example.libraryManagement.service.AuthorServiceInterf;

@RestController
public class AuthorController {
  
	@Autowired
	AuthorServiceInterf authorServiceInterf;
	
	@GetMapping("/findByEmail")
	public AuthorSearchResponse findByEmail(@RequestParam("email")String email)
	{
		return authorServiceInterf.findAuthorResponseFromAuthor(email);
	}
}
