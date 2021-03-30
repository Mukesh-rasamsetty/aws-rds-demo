package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DemoController {
	
	private EmployeeRepository repository;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<Employee>> getAllStudents() {
		return new ResponseEntity<List<Employee>>(repository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> employee = repository.findById(id);
		if(employee.isPresent())
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.FOUND);
		else
			return new ResponseEntity<Employee>(new Employee(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(repository.save(employee),HttpStatus.CREATED);
	}
	
	@PutMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		if(repository.findById(employee.getId()).isPresent())
			return new ResponseEntity<Employee>(repository.save(employee), HttpStatus.CREATED);
		return new ResponseEntity<Employee>(repository.save(new Employee()), HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		Optional<Employee> employee = repository.findById(id);
		if(employee.isPresent()) {
			repository.deleteById(id);
			return new ResponseEntity<Employee>(employee.get(), HttpStatus.CREATED);
		}
		return new ResponseEntity<Employee>(new Employee(), HttpStatus.NOT_MODIFIED);
	}

}
