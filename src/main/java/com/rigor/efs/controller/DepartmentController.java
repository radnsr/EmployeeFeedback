package com.rigor.efs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rigor.efs.model.Department;
import com.rigor.efs.service.DepartmentService;

@Controller
@RequestMapping("/")
public class DepartmentController {
	@Autowired
	DepartmentService service;

	@Autowired
	MessageSource messagesource;

	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listDepartment(ModelMap model) {

		List<Department> department = service.findAllDepartments();
		model.addAttribute("department", department);
		return "dapartment_list";
	}

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Department department = new Department();
		model.addAttribute("employee", department);
		model.addAttribute("edit", false);
		return "department_form";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * saving employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Department department, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "department_form";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be
		 * implementing custom @Unique annotation and applying it on field [ssn]
		 * of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you
		 * can fill custom errors outside the validation framework as well while
		 * still using internationalized messages.
		 * 
		 */
		if (!service.isEmployeeSsnUnique(department.getDept_id())) {

			return "department_form";
		}

		service.saveDepartment(department);

		return "department_list";
	}

	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{id}-department" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable int id, ModelMap model) {
		Department department = service.findDepartmentById(id);
		model.addAttribute("department", department);
		model.addAttribute("edit", true);
		return "department_form";
	}

	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{id}-department" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Department department, BindingResult result, ModelMap model,
			@PathVariable String ssn) {

		if (result.hasErrors()) {
			return "department_form";
		}

		service.updateDepartment(department);

		return "department_list";
	}



	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{id}-department" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable int id) {
		service.deleteDepartmentById(id);
		return "redirect:/list";
	}

}
