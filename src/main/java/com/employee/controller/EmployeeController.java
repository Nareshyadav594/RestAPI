package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

 
@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController implements SwaggerInterface {

	@Autowired
	private EmployeeService employeeService;

	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();

	}

	public Employee getByEmployeeId(

			@PathVariable int id) {
		return employeeService.getByEmployeeId(id);

	}

	public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);

	}

	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
}
