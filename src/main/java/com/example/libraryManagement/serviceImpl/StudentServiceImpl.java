package com.example.libraryManagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libraryManagement.enums.AccountStatus;
import com.example.libraryManagement.models.Book;
import com.example.libraryManagement.models.Student;
import com.example.libraryManagement.repository.BookRepositoryInterf;
import com.example.libraryManagement.repository.StudentRepositoryInterf;
import com.example.libraryManagement.requests.StudentCreateRequest;
import com.example.libraryManagement.service.StudentServiceInterf;

@Service
public class StudentServiceImpl implements StudentServiceInterf {

	@Autowired
	StudentRepositoryInterf studentRepositoryInterf;
	
	@Autowired
	BookRepositoryInterf bookRepositoryInterf;
	
	@Override
	public Student save(StudentCreateRequest studentCreateRequest) {
		 return saveFromStudent(studentCreateRequest.toStudent());
	}

	@Override
	public Student saveFromStudent(Student student) {
	     return studentRepositoryInterf.save(student);
	}

	@Override
	public Student findById(int studentId) {
		 return studentRepositoryInterf.findById(studentId).get();
	}

	@Override
	public void deleteById(int studentId) {
		Student student = studentRepositoryInterf.findById(studentId).get();
		List<Book> bookList = student.getBookList();
		
		for(Book book : bookList) {
			book.setStudent(null);
		}
		student.setBookList(null);
		student.setAccountStatus(AccountStatus.INACTIVE);
		studentRepositoryInterf.save(student);
	}

}
