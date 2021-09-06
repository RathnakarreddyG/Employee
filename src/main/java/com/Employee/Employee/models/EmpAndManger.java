package com.Employee.Employee.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_manager")
public class EmpAndManger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_manager_id;
	
	private Long emp_id;
	
	private Long manager_id;

	public EmpAndManger() {
		super();
	}
	
	public EmpAndManger(Long emp_id, Long manager_id) {
		super();
		this.emp_id = emp_id;
		this.manager_id = manager_id;
	}



	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public Long getManager_id() {
		return manager_id;
	}

	public void setManager_id(Long manager_id) {
		this.manager_id = manager_id;
	}
	
	
	
}
