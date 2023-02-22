package com.example.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryManagement.models.Student;

public interface StudentRepositoryInterf extends JpaRepository<Student,Integer> {

}
