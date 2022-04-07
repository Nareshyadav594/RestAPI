package com.employee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.EmployeeNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
 		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
 		return employeeRepository.findAll();
	}

	 

	@Override
	public Employee updateEmployee(int id, Employee employee) {
 		Employee employeedb=getByEmployeeId(id);
 		employeedb.setDepartment(employee.getDepartment());
 		employeedb.setName(employee.getName());
 		employeedb.setId(employee.getId());
 		employeeRepository.save(employeedb);
 		return employeedb;
	}

	@Override
	public void deleteEmployee(int id) {
 		Employee employeedb=getByEmployeeId(id);
employeeRepository.delete(employeedb);
 	}

	@Override
	public Employee getByEmployeeId(int id) {
 		return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("employee id is not present"));
	}

	 
}
