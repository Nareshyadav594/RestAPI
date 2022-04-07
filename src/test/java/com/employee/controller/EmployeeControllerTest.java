package com.employee.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

	@Mock
	private EmployeeService employeeServiceMock;

	@InjectMocks
	private EmployeeController employeeControllerMock;

	@Test
	public void saveEmployeeTest() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("naresh");
		employee.setDepartment("cloud");
		when(employeeServiceMock.saveEmployee(employee)).thenReturn(employee);
		employee = employeeControllerMock.saveEmployee(employee);
		assertNotNull(employee);
	}

	@Test
	public void getAllEmployeeTest() {
		List<Employee> list = new ArrayList<>();
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("naresh");
		employee.setDepartment("cloud");
		list.add(employee);
		when(employeeServiceMock.getAllEmployee()).thenReturn(Arrays.asList(employee));
		list = employeeControllerMock.getAllEmployee();
		assertNotNull(employee);
		assertNotNull(list);
	}

	@Test
	public void getByEmployeeIdTest() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("naresh");
		employee.setDepartment("cloud");
		int id = 1;
		when(employeeServiceMock.getByEmployeeId(id)).thenReturn(employee);
		employee = employeeControllerMock.getByEmployeeId(id);
		assertNotNull(employee);
	}

	@Test
	public void updateEmployeeTest() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("naresh");
		employee.setDepartment("cloud");
		int id = 1;
		when(employeeServiceMock.updateEmployee(id, employee)).thenReturn(employee);
		employee = employeeControllerMock.updateEmployee(id, employee);
		assertNotNull(employee);

	}
	
	 
}
