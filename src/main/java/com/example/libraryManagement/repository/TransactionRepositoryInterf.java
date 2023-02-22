package com.example.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libraryManagement.enums.TransactionType;
import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.models.Student;
import com.example.libraryManagement.models.Transaction;

public interface TransactionRepositoryInterf extends JpaRepository<Transaction,Integer>{

	Transaction findTopByBookAndStudentAndTransactionTypeOrderByIdDesc(Book book,Student student,TransactionType issue);
	
}
