package com.syrine.bookc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.syrine.bookc.models.Book;
import com.syrine.bookc.models.User;
import com.syrine.bookc.services.BookService;
import com.syrine.bookc.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, HttpSession s) {
		//get the user id from the session
		Long userId = (Long) s.getAttribute("user_id");
		//if the user is not logged in
		if(userId == null) {
			//redirect to the login page
			return "redirect:/";
		}
		return"newbook.jsp";
	}

		@PostMapping("/processbook")
	public String createBook(@Valid @ModelAttribute("book") Book book ,BindingResult result, HttpSession s) {
		//get the user id from the session
		Long userId = (Long) s.getAttribute("user_id");
		//if there are errors in the form
		if(result.hasErrors()) {
			//return the new page
			return"newbook.jsp";
			//if there are no errors
		}else {
			//find the user by the id
			User user = userServ.findUserById(userId);
			System.out.println("**********************"+user);
			//set the user as the owner of the car
			book.setPostedBy(user);
			System.out.println("**********************"+book.getPostedBy());	
			//create the car
			Book newBook = bookServ.createBook(book);
			//redirect to the show page of the car
			return "redirect:/books";
		}
		
	}

	@GetMapping("/books")
	public String home(Model model,HttpSession s) {
		//get the user id from the session
		Long userId = (Long) s.getAttribute("user_id");
		if(userId == null) {
			//redirect to the login page
			return "redirect:/";
		}
		User user = userServ.findUserById(userId);
		model.addAttribute("user",user);
		List<Book> allBooks = bookServ.allBook();
		model.addAttribute("allBook",allBooks);
		return"home.jsp";
	}

	//show one book details
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id")Long id,Model model, HttpSession s) {
		//get the user id from the session
		Long userId = (Long) s.getAttribute("user_id");
		if(userId == null) {
			//redirect to the login page
			return "redirect:/";
		}
		User user = userServ.findUserById(userId);
		Book book = bookServ.findBookById(id);
		model.addAttribute("book",book);
		model.addAttribute("user",user);
		return"showbook.jsp";
	}

	//!edit book
	//get the book by id
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id")Long id,Model model, HttpSession s) {
		//get the user id from the session
		Long userId = (Long) s.getAttribute("user_id");
		if(userId == null) {
			//redirect to the login page
			return "redirect:/";
		}
		Book book = bookServ.findBookById(id);
		model.addAttribute("book",book);
		return"edit.jsp";
	}

	//update the book
	@PutMapping("/processbook/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book ,BindingResult result, HttpSession s) {
		//get the user id from the session
		Long userId = (Long) s.getAttribute("user_id");
		if(result.hasErrors()) {
			return"edit.jsp";
		}else {
			//find the user by the id
			User user = userServ.findUserById(userId);
			//set the user as the owner 
			book.setPostedBy(user);
			bookServ.updateBook(book);
		return "redirect:/books";
		}
	}
	@DeleteMapping("/books/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
    	bookServ.deleteBook(id);
    	 return "redirect:/books";
    }

}
