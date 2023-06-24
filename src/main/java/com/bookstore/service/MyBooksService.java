package com.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBooksRepository;

@Service
public class MyBooksService 
{
	@Autowired
	MyBooksRepository myBookRepo;
	
	public void saveMyBook(MyBookList myBook)
	{
		myBookRepo.save(myBook);
	}
	
	
	public List<MyBookList> getAllMyBooks() 
	{
		return myBookRepo.findAll();
			
	}
	
	public void deleteById(int id)
	{
		myBookRepo.deleteById(id);
	}
	
	public MyBookList getBookById(int id)
	{
		return myBookRepo.findById(id).get();
	}

}
