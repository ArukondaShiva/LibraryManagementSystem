package com.example.libraryManagement.controller;

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

import com.example.libraryManagement.models.Student;
import com.example.libraryManagement.requests.StudentCreateRequest;
import com.example.libraryManagement.service.StudentServiceInterf;

@RestController
public class StudentController {

	@Autowired
	StudentServiceInterf studentServiceInterf;
	
	@PostMapping("/saveStudent")
	public ResponseEntity saveStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest) {
		return new  ResponseEntity(studentServiceInterf.save(studentCreateRequest),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteStudent")
	public ResponseEntity deleteStudent(@RequestParam("id") int studentId) {
		studentServiceInterf.deleteById(studentId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/searchStudent")
	public Student findStudentById(@RequestParam("id") int studentId) {
		return studentServiceInterf.findById(studentId);
	}
	
}
