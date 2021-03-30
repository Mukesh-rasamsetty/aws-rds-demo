package com.cognizant.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cognizant.model.Employee;
import com.cognizant.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional
	public void addEmployee(Employee employee) {
		repository.save(employee);
	}

	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
