package com.rigor.efs.dao;

import java.util.List;

import com.rigor.efs.model.Department;


public interface DepartmentDAO {
	
	Department findById(int id);

	void saveDepartment(Department department);
	
	void deleteDepartmentById(int id);
	
	List<Department> findAllDepartments();

	Department findDepartmentById(int id);
}
