package com.example.Assignment5_Application2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment5_Application2.model.Employee;
import com.example.Assignment5_Application2.service.EmployeeService;

@RestController
public class EmployeeController {
	
	//private String URL="http://localhost:8080/Assignment5_Day18-22_App1";
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		try {
			return this.employeeService.getEmployees();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/employees/{empCode}")
	public Employee showFormForUpdate(@PathVariable String empCode) {
		try {
			return this.employeeService.getEmployeeById(Long.parseLong(empCode));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/employees")
	public Employee showNewEmployeeForm(@RequestBody Employee updatedEmployee) {
		// create model attribute to bind form data
		try {
			return this.employeeService.updateEmployee(updatedEmployee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping(value = "/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		// save employee to database
		try {
			return employeeService.addEmployee(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/employees/{empCode}")
	public void deleteEmployee(@PathVariable String empCode) {
		// call delete employee method 
		try {
			this.employeeService.deleteEmployeeById(Long.parseLong(empCode));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
