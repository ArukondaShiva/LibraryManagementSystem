package com.example.libraryManagement.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.libraryManagement.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Enumerated
	private TransactionType transactionType;
	
	private double payment;
	
	@ManyToOne
	private Book book;
	
	@ManyToOne
	private Student student;
	
	@CreationTimestamp
	private Date createdOn;

	private String externalId;
	
	public String getExternalId() {
		// TODO Auto-generated method stub
		return null;
	}
	public TransactionBuilder externalId(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}













