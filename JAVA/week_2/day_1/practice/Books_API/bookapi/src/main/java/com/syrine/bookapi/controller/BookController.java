package com.syrine.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.syrine.bookapi.models.Book;
import com.syrine.bookapi.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id")Long id, Model model) {
		
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}@RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
}
