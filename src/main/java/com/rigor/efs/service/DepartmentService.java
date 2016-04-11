package com.rigor.efs.service;

import java.util.List;

import com.rigor.efs.model.Department;


public interface DepartmentService {

	Department findById(int id);
	
	void saveDepartment(Department department);
	
	void updateDepartment(Department department);
	
	void deleteDepartmentById(int id);

	List<Department> findAllDepartments(); 
	
	Department findDepartmentById(int id);

	boolean isEmployeeSsnUnique(Integer id);
}
