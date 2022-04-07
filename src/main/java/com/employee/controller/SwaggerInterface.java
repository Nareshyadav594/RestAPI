package com.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.employee.model.Employee;

import io.swagger.v3.oas.annotations.Operation;
 import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface SwaggerInterface {
	
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",description = "successfully data created in DB"),
			@ApiResponse(responseCode = "401",description = "UnAuthorized"),
			@ApiResponse(responseCode = "402",description = "Forbiden")


	})

	@PostMapping("/save")
	@Operation(summary = "create new book data in DB")

	public Employee saveEmployee(@RequestBody Employee employee);

	@GetMapping("/getAllemployees")
	@Operation(summary = "get all books data from DB")
	public List<Employee> getAllEmployee();

	@GetMapping("/{id}")
	@Operation(summary = "get  bookId data from DB")
	public Employee getByEmployeeId(

			@PathVariable int id);

	@PutMapping("/{id}")
	@Operation(summary = "update exixting book data from DB")

	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee);

	@DeleteMapping("/delete/{id}")
	@Operation(summary = "delete book data from DB")
	public void deleteEmployee(@PathVariable int id);
}