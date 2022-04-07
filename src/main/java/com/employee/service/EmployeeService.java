package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.model.Employee;

@Service
public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();
 

	public Employee updateEmployee(int id, Employee employee);

	public void deleteEmployee(int id);

	Employee getByEmployeeId(int id);
}
