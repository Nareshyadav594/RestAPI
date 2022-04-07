package com.javaexpress.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.javaexpress.model.Book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface SwaggerInterface {
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",description = "successfully data created in DB"),
			@ApiResponse(responseCode = "401",description = "UnAuthorized"),
			@ApiResponse(responseCode = "402",description = "Forbiden")


	})
	@Operation(summary = "create new book data in DB")
	@PostMapping(value = "/api/v1/book/create", produces = { "application/json" }, consumes = { "application/json" })
@ResponseStatus(code = HttpStatus.CREATED)	
	public void saveBook(@RequestBody Book book);
	
	
	
	@Operation(summary = "get all books data from DB")
	@GetMapping("/api/v1/book/getAllBooks")
@ResponseStatus(code = HttpStatus.CREATED)		
	public List<Book> getAllBook();


	
	@Operation(summary = "get  bookId data from DB")
	@GetMapping("/api/v1/book/{bookId}")
@ResponseStatus(code = HttpStatus.OK)	
	public Book getByBookId(
			@Parameter(description = "required to provide ID for particular data get",required = true)
			
			@PathVariable("bookId") int id);
	
	
	

	@Operation(summary = "update exixting book data from DB")
	@PutMapping("/api/v1/book/{bookId}")
@ResponseStatus(code = HttpStatus.OK)	
	public Book updateBook(
			@Parameter(description = "required to provide ID for update daata from DB",required = true)

			@PathVariable("bookId") int id, @RequestBody Book book) throws Exception;
	
	
	@Operation(summary = "delete book data from DB")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)	

		@DeleteMapping("/api/v1/book/{bookId}")
		public void deleleBook(
				@Parameter(description = "required to provide ID for delete daata from DB",required = true)

				@PathVariable("bookId") int id);


}
