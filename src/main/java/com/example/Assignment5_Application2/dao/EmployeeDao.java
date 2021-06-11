package com.example.Assignment5_Application2.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.Assignment5_Application2.model.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long>{

}
