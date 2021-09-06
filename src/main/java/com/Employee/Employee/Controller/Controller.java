package com.Employee.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Employee.DTO.EmpAndProjectDTO;
import com.Employee.Employee.DTO.EmployeeDTO;
import com.Employee.Employee.models.Department;
import com.Employee.Employee.models.Project;
import com.Employee.Employee.models.Roles;
import com.Employee.Employee.services.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class Controller {

	@Autowired
	public EmployeeService empService;

	@GetMapping("/test")
	public String sprinHello() {
		return "Hello";
	}

	@PostMapping("/addDepartment")
	public Department addDepartment(@RequestBody Department department) {
		return empService.addDeprtment(department);
	}

	@PostMapping("/addroles")
	public Roles addRole(@RequestBody Roles role) {
		return empService.addRole(role);

	}

	@PostMapping("/addProject")
	public Project addProject(@RequestBody Project project) {
		return empService.addProject(project);
	}
	
	@GetMapping("/project/{id}")
	public Object getProject(@PathVariable Long id) {
		return empService.getProject(id);
	}
	@GetMapping("/department/{id}")
	public Object getDepartment(@PathVariable Long id) {
		return empService.getDepartment(id);
	}
	@PostMapping("/addEmployee")
	public Object addEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return empService.addEmployee(employeeDTO);
	}
	@GetMapping("/employee/{id}")
	public Object getEmployee(@PathVariable Long id) {
		return empService.getEmployee(id);
	}
	
	@GetMapping("/getEmpWithManager/{empId}")
	public Object getEmpWithManager(@PathVariable Long empId) {
		return empService.getEmpWithManager(empId);
	}
	@PostMapping("/assignManagerToEmp/{empid}/{managerid}")
	public Object assignManager(@PathVariable Long empid,@PathVariable Long managerid) {
		return empService.assignManager(empid, managerid);
	}
	
	@GetMapping("/getDepartmentWiseHighSalariedEmployee/{departmentId}")
	public Object getDepartmentWiseHighSalariedEmployee(@PathVariable Long departmentId) {
		return empService.getDepartmentWiseHighSalariedEmployee(departmentId);
	}
	@PostMapping("/assignToEmployeeProject")
	public Object assignToEmployeeProject(@RequestBody EmpAndProjectDTO empAndProjectDTO) {
		return empService.assignToEmployeeProject(empAndProjectDTO);
	}
	@GetMapping("/getEmployeeWithMultipleProjects")
	public Object getEmployeeWithMultipleProjects() {
		return empService.getEmployeeDetailsMoreThanOneProject();
	}
}
