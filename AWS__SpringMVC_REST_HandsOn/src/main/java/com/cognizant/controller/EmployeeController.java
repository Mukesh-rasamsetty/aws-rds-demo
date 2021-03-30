package com.cognizant.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/")
public class EmployeeController {

	private EmployeeService service;

	private ModelAndView getEmployeeList() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("employeeList", service.getAllEmployees());
		return modelAndView;
	}

	@GetMapping(path = "/")
	public ModelAndView employeeList() {
		return getEmployeeList();
	}

	@GetMapping("/{id}")
	public ModelAndView deleteEmployee(@PathVariable String id) {
		service.deleteEmployee(Integer.parseInt(id));
		ModelAndView view = getEmployeeList();
		view.addObject("status", "Delete Successfull");
		return view;
	}

	@GetMapping("/Employee")
	public ModelAndView addEmployee(@ModelAttribute Employee employee) {
		return new ModelAndView("add");
	}

	@PostMapping("/Employee")
	public ModelAndView addingEmployee(@Valid @ModelAttribute Employee employee, BindingResult results) {
		if (results.hasErrors())
			return new ModelAndView("add");
		System.out.println(employee);
		service.addEmployee(employee);
		ModelAndView view = getEmployeeList();
		view.addObject("status", "Successfully");
		return view;
	}
	
	@PostMapping("/{id}")
	public ModelAndView putEmployee(@PathVariable String id, @ModelAttribute Employee employee) {
		employee = service.getEmployeeById(Integer.parseInt(id));
		ModelAndView view = new ModelAndView("update");
		view.addObject("employee", employee);
		return view;
	}

}
