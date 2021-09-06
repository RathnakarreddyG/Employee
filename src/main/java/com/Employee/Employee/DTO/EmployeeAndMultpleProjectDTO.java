package com.Employee.Employee.DTO;

import java.util.List;

import com.Employee.Employee.models.EmployeeDetails;
import com.Employee.Employee.models.Project;

public class EmployeeAndMultpleProjectDTO {

	private EmployeeDetails employeeDetails;

	private List<Project> project;

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

}
