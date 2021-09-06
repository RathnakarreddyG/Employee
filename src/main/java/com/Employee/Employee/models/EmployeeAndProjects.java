package com.Employee.Employee.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_and_projects")
public class EmployeeAndProjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_project_id;
	
	
	private Long emp_id;
	
	
	private Long project_id;


	public EmployeeAndProjects() {
		super();
	}


	public EmployeeAndProjects(Long emp_id, Long project_id) {
		super();
		this.emp_id = emp_id;
		this.project_id = project_id;
	}


	public Long getEmployee_project_id() {
		return employee_project_id;
	}


	public void setEmployee_project_id(Long employee_project_id) {
		this.employee_project_id = employee_project_id;
	}


	public Long getEmp_id() {
		return emp_id;
	}


	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}


	public Long getProject_id() {
		return project_id;
	}


	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	
	
	

}
