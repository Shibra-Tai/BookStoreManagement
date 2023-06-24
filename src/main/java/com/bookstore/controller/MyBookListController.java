package com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBooksService;

@Controller
public class MyBookListController 
{
	@Autowired
	private MyBooksService service;
	
	@Autowired 
	private BookService bookService;
	
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id)
	{
		service.deleteById(id);
		return "redirect:/mybooks";
	}

	
}
