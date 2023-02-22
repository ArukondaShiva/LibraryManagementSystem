package com.example.libraryManagement.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryManagement.enums.BookFilterType;
import com.example.libraryManagement.enums.BookSearchOperationType;
import com.example.libraryManagement.enums.Genre;
import com.example.libraryManagement.exception.InvalidIdException;
import com.example.libraryManagement.models.Author;
import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.repository.BookRepositoryInterf;
import com.example.libraryManagement.repository.TransactionRepositoryInterf;
import com.example.libraryManagement.requests.BookCreateRequest;
import com.example.libraryManagement.response.BookSearchResponse;
import com.example.libraryManagement.service.AuthorServiceInterf;
import com.example.libraryManagement.service.BookServiceInterf;

@Service
public class BookServiceImpl implements BookServiceInterf {

	@Autowired
	BookRepositoryInterf bookRepositoryInterf;
	
	@Autowired
	AuthorServiceInterf authorServiceInterf;
	
	@Autowired
	TransactionRepositoryInterf transactionRepositoryInterf;
	
	@Override
	public Book create(BookCreateRequest bookCeateRequest) {
		
		 Book book = bookCeateRequest.toBook();
	     
		 Author author = book.getAuthor();
		 
		 Author authorfromDb =  authorServiceInterf.findByEmail(author.getEmail());

		 if(authorfromDb==null) {
			 authorfromDb = authorServiceInterf.createAuthor(author);
		 }
         book.setAuthor(authorfromDb);
		  
		 return bookRepositoryInterf.save(book);
	}

	
	@Override
	public Book save(Book book) {
	 	return bookRepositoryInterf.save(book);
	}
	

	@Override
	public Book findById(Integer id) {
		return bookRepositoryInterf.findById(id).get();
	}
	
	public List<BookSearchResponse> findFilteredBooks(BookFilterType bookFilterType, String value){
		return find(bookFilterType,value).stream()
		 .map(book->book.toBookSearchResponse())
		 .collect(Collectors.toList());
	}


	
	public List<Book> find(BookFilterType bookFilterType, String value) {
	 
		switch(bookFilterType) {
		  case NAME:
			  return bookRepositoryInterf.findByName(value);
		  case GENRE:
			  return bookRepositoryInterf.findByGenre(Genre.valueOf(value));
		  case AUTHOR_NAME:
			  return bookRepositoryInterf.findByAuthor_name(value);
		  case COST:
			  return bookRepositoryInterf.findByCost(Integer.parseInt(value));
		  case ID:
			  return bookRepositoryInterf.findAllById(new ArrayList<Integer>(Integer.parseInt(value)));
		}
		return null;
	}
	
	
	@Override
	public void deleteById(int id) throws InvalidIdException {
		 
		Book book = bookRepositoryInterf.findById(id).get();
		if(book==null) {
			throw new InvalidIdException("Book with given id not exists");
		}
		book.setStudent(null);
		bookRepositoryInterf.deleteById(id);
	}

	 
}











