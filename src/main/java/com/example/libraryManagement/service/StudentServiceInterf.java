package com.example.libraryManagement.service;

import com.example.libraryManagement.models.Student;
import com.example.libraryManagement.requests.StudentCreateRequest;


public interface StudentServiceInterf {
	Student save(StudentCreateRequest studentCreateRequest);
	Student saveFromStudent(Student student);
	Student findById(int studentId);
	void deleteById(int studentId);
}
