package com.rigor.efs.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.rigor.efs.model.Department;

@Repository("departmentDao")
public class DepartmentDAOImpl extends AbstractDao<Integer, Department> implements DepartmentDAO {

	public Department findById(int id) {
		return getByKey(id);
	}

	public void saveDepartment(Department department) {
		// TODO Auto-generated method stub
		persist(department);
	}

	public void deleteDepartmentById(int id) {
		Query query = getSession().createSQLQuery("DELETE FROM department WHERE id = :id");
		query.setInteger("id", id);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<Department> findAllDepartments() {
		Criteria criteria = createEntityCriteria();
		return (List<Department>) criteria.list();
	}

	public Department findDepartmentById(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Department) criteria.uniqueResult();
	}

}
