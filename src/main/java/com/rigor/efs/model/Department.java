package com.rigor.efs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="department_tbl")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dept_id;
	
	@Size(min=3, max=50)
	@Column(name = "dept_name", nullable = false)
	private String dept_name;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	
	public Department(){
		status=1;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dept_id;
		result = prime * result + ((dept_name == null) ? 0 : dept_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Department))
			return false;
		Department other = (Department) obj;
		if (dept_id != other.dept_id)
			return false;
		if (dept_name == null) {
			if (other.dept_name != null)
				return false;
		} else if (!dept_name.equals(other.dept_name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Deparment [dept_id=" + dept_id + ", dept_name=" + dept_name + ", status=" + status + "]";
	}


}
