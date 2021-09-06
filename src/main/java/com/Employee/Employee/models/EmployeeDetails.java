package com.Employee.Employee.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emp_id;
	
	private String emp_name;
	
	private Long salary;
	
	@ManyToOne
	@JoinColumn(name = "role_id",referencedColumnName = "role_id")
	private Roles role;
	
	@ManyToOne
	@JoinColumn(name = "department_id",referencedColumnName = "department_id")
	private Department department;


	public EmployeeDetails() {
		super();
	}

	public Long getEmp_id() {
		return emp_id;
	}
		

	public EmployeeDetails(String emp_name, Long salary, Roles role, Department department) {
		super();
		this.emp_name = emp_name;
		this.salary = salary;
		this.role = role;
		this.department = department;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	
	
	
	
	
}
