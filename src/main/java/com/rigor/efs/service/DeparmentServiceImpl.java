package com.rigor.efs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rigor.efs.dao.DepartmentDAO;
import com.rigor.efs.model.Department;

@Service("departmentService")
@Transactional
public class DeparmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDAO dao;
	
	public Department findById(int id) {
		
		return dao.findById(id);
	}

	public void saveDepartment(Department department) {
		dao.saveDepartment(department);
		
	}
	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateDepartment(Department department) {
		
		Department entity = dao.findById(department.getDept_id());
		if(entity!=null){
			entity.setDept_name(department.getDept_name());
		}
		
	}

	public void deleteDepartmentById(int id) {
		dao.deleteDepartmentById(id);
		
	}

	public List<Department> findAllDepartments() {
		return dao.findAllDepartments();
	}

	public Department findDepartmentById(int id) {
		// TODO Auto-generated method stub
		return dao.findDepartmentById(id);
	}

	public boolean isEmployeeSsnUnique(Integer id) {
		Department deaprtment = findDepartmentById(id);
		return ( deaprtment == null || ((id != null) && (deaprtment.getDept_id() == id)));
	}

}
