package com.example.libraryManagement.service;

import com.example.libraryManagement.exception.TransactionServiceException;

public interface TransactionServiceInterf {

	String issueTxn(int studentId,int bookId) throws TransactionServiceException;
	
	String returntxn(int studentId,int BookId) throws TransactionServiceException;
	
}
