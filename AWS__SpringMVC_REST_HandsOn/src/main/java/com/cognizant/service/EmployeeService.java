package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();

	void deleteEmployee(int id);

	void addEmployee(Employee employee);

	void updateEmployee(Employee employee);

	Employee getEmployeeById(int id);
}
