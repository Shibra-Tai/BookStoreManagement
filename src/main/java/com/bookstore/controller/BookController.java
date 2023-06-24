package com.bookstore.controller;

import com.bookstore.entity.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBooksService;

@Controller
public class BookController 
{

	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyBooksService myBooksService;
	
	@GetMapping("/")  // For get request
	public String home()
	{
		return "home";
	}
	
	
	
	@GetMapping("/addnewbook")
	public String addNewBook()
	{
		return "addnewbook.html";
	}
	
	
	@GetMapping("/availablebooks")
	public ModelAndView availableBooks()  // Here we want to return data so the return type is ModelAndView
	{
		List<Book> listOfBooks = bookService.getAllBooks();
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("availablebooks");
//		mv.addObject("book", listOfBooks);
//		
		return new ModelAndView("availablebooks","book",listOfBooks);
	}
	
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book)  //ModelAttribute: will get form data int obook object
	{
		
		bookService.save(book);  // to save book object to database 
		return "redirect:/availablebooks";
	}

	
	
	@GetMapping("/mybooks")
	public String myBooks(Model model)
	{
		
		List<MyBookList> myAllBooks = myBooksService.getAllMyBooks();
		model.addAttribute("book", myAllBooks);
		
		return "mybooks";
	}
	
	
	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		Book book = bookService.getBookById(id);
		MyBookList myBookList = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
		
		myBooksService.saveMyBook(myBookList);
		
		return "redirect:/mybooks";
	}
	
	
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id)
	{
		bookService.deleteBook(id);
		return "redirect:/availablebooks";
	}
	
	
	@RequestMapping("/editbook/{id}")
	public String editBook(@PathVariable("id") int id, Model model)
	{
		
		Book book = bookService.getBookById(id);
		model.addAttribute("book", book);
		return "editbook";
	}
}
