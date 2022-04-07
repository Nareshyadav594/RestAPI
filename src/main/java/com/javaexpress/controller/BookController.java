package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.model.Book;
import com.javaexpress.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BookController implements SwaggerInterface{

	@Autowired
	private BookService bookService;
	

public void saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
	}
	public List<Book> getAllBook() {
		return bookService.getAllBook();
	}

	// input is primary key -output is object
	// pathvariable-mandentory to provide
	public Book getByBookId(
			@Parameter(description = "required to provide ID for particular data get",required = true)
			
			@PathVariable("bookId") int id) {
		return bookService.getByBookId(id);
	}

	public Book updateBook(
			@Parameter(description = "required to provide ID for update daata from DB",required = true)

			@PathVariable("bookId") int id, @RequestBody Book book)  {
		return (Book) bookService.updateBook(id, book);
	}
  
 	public void deleleBook(@PathVariable("bookId") int id) {
		bookService.deleteBook(id);

	}

}
