package com.example.Assignment5_Application2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Assignment5_Application2.dao.EmployeeDao;
import com.example.Assignment5_Application2.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;
	
	public List<Employee> getEmployees(){
		return empDao.findAll();
	}
	
	public Employee getEmployeeById(long id) {
		return empDao.findById(id).get();
	}
	
	
	public Employee addEmployee(Employee employee) {
		 return empDao.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		 return empDao.save(employee);
		// return employee;
	}

	public void deleteEmployeeById(long id) {
		Employee emp=empDao.findById(id).get();
		empDao.delete(emp);
	}

}
