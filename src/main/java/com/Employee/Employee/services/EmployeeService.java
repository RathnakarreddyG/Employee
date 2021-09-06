package com.Employee.Employee.services;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Employee.DAO.DepartmentDAO;
import com.Employee.Employee.DAO.EmpAndManagerDAO;
import com.Employee.Employee.DAO.EmployeeAndProjectsDAO;
import com.Employee.Employee.DAO.EmployeeDAOS;
import com.Employee.Employee.DAO.ProjectADAO;
import com.Employee.Employee.DAO.RoleDAO;
import com.Employee.Employee.DTO.EmpAndProjectDTO;
import com.Employee.Employee.DTO.EmployeeAndMultpleProjectDTO;
import com.Employee.Employee.DTO.EmployeeDTO;
import com.Employee.Employee.models.Department;
import com.Employee.Employee.models.EmpAndManger;
import com.Employee.Employee.models.EmployeeAndProjects;
import com.Employee.Employee.models.EmployeeDetails;
import com.Employee.Employee.models.Project;
import com.Employee.Employee.models.Roles;

@Service
public class EmployeeService {

	@Autowired
	public EmployeeDAOS employeeDAOS;

	@Autowired
	public DepartmentDAO departmentDAO;

	@Autowired
	public ProjectADAO projectADAO;

	@Autowired
	public RoleDAO roleDAO;

	@Autowired
	public EmpAndManagerDAO empAndManagerDAO;

	@Autowired
	public EmployeeAndProjectsDAO employeeAndProjectsDAO;

	public Department addDeprtment(Department department) {

		Department department_details = departmentDAO.save(department);

		return department_details;
	}

	public Roles addRole(Roles role) {

		role.setCreatedate(LocalDate.now());
		Roles role_details = roleDAO.save(role);
		return role_details;
	}

	public Project addProject(Project project) {
		Project project_details = projectADAO.save(project);
		return project_details;
	}

	public Object getProject(Long projectid) {
		Optional<Project> project_details = projectADAO.findById(projectid);
		if (project_details.isPresent()) {
			return project_details.get();
		} else {
			return "Project not found";
		}

	}

	public Object getDepartment(Long departmentid) {
		Optional<Department> details = departmentDAO.findById(departmentid);
		if (details.isPresent()) {
			return details.get();
		} else {
			return "Department not found";
		}
	}

	public Object addEmployee(EmployeeDTO employeeDTO) {
		Optional<Roles> checkRole = roleDAO.findById(employeeDTO.getRole_id());
		Optional<Department> checkDepartment = departmentDAO.findById(employeeDTO.getDepartment_id());

		if (checkRole.isPresent() && checkDepartment.isPresent()) {
			EmployeeDetails employee = employeeDAOS.save(new EmployeeDetails(employeeDTO.getEmp_name(),
					employeeDTO.getSalary(), checkRole.get(), checkDepartment.get()));

			return employee;
		} else {
			return "Details not found";
		}

	}

	public Object getEmployee(Long emp_id) {
		Optional<EmployeeDetails> emp = employeeDAOS.findById(emp_id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			return "employee not found";
		}
	}

	public Object getEmpWithManager(Long empId) {
		Optional<EmployeeDetails> checkEmp = employeeDAOS.findById(empId);
		List<Object> empDetails = new ArrayList<>();
		if (checkEmp.isPresent()) {
			EmpAndManger empAndManger = empAndManagerDAO.findByEmpId(empId);
			if (empAndManger != null) {
				Optional<EmployeeDetails> employee = employeeDAOS.findById(empAndManger.getEmp_id());
				Optional<EmployeeDetails> manaager = employeeDAOS.findById(empAndManger.getManager_id());
				empDetails.add(employee.get());
				empDetails.add(manaager.get());
				return empDetails;
			} else {
				return "Manager details not found";
			}

		} else {

			return "details Not found";
		}
	}

	public Object assignManager(Long emp_id, Long manager_id) {
		Optional<EmployeeDetails> checkRole = employeeDAOS.findById(emp_id);
		Optional<EmployeeDetails> checkRoleManager = employeeDAOS.findById(manager_id);
		if (checkRole.isPresent() && checkRoleManager.isPresent()) {

			if (checkRole.get().getRole().getRole_name().equalsIgnoreCase("Employee")
					&& checkRoleManager.get().getRole().getRole_name().equalsIgnoreCase("Manager")) {

				EmpAndManger empAndManger = new EmpAndManger(emp_id, manager_id);
				empAndManagerDAO.save(empAndManger);

				return "manager assigned Successfully";

			} else {
				return "Role Should be employee";
			}

		} else {
			return "Employee details not found";
		}
	}

	public Object getDepartmentWiseHighSalariedEmployee(Long departmentId) {

		List<EmployeeDetails> emplist = employeeDAOS.findByEmployeeHighSalaryDepartmentWise(departmentId);

		return emplist;
	}

	public Object assignToEmployeeProject(EmpAndProjectDTO empAndProjectDTO) {
		Optional<EmployeeDetails> employeeDetails = employeeDAOS.findById(empAndProjectDTO.getEmp_id());
		Optional<Project> project = projectADAO.findById(empAndProjectDTO.getProject_id());
		if (employeeDetails.isPresent() && project.isPresent()) {
			EmployeeAndProjects employeeAndProjects = new EmployeeAndProjects(empAndProjectDTO.getEmp_id(),
					empAndProjectDTO.getProject_id());
			employeeAndProjectsDAO.save(employeeAndProjects);
			return "" + project.get().getProject_name() + " Project Assigned Successfully To "
					+ employeeDetails.get().getEmp_name();
		} else {
			return "Details not found";
		}
	}

	public Object getEmployeeDetailsMoreThanOneProject() {
		List<Object> finaldata = new ArrayList<Object>();
		//to get all employees
		List<EmployeeDetails> totalEmpList = employeeDAOS.findAll();
		
		for (EmployeeDetails detais : totalEmpList) {
			EmployeeAndMultpleProjectDTO employeeAndMultpleProjectDTO = new EmployeeAndMultpleProjectDTO();
			
			List<EmployeeAndProjects> employeeAndProjects = employeeAndProjectsDAO.findByEmpId(detais.getEmp_id());
			
			if (employeeAndProjects.size() > 1) {
				EmployeeAndProjects employeeAndProjects2 = employeeAndProjects.get(0);
				Optional<EmployeeDetails> employeeDetails = employeeDAOS.findById(employeeAndProjects2.getEmp_id());

				employeeAndMultpleProjectDTO.setEmployeeDetails(employeeDetails.get());
				List<Project> projectList = new ArrayList<Project>();

				employeeAndProjects.forEach(data -> {
					Optional<Project> project = projectADAO.findById(data.getProject_id());
					projectList.add(project.get());
				});
				employeeAndMultpleProjectDTO.setProject(projectList);
				finaldata.add(employeeAndMultpleProjectDTO);
				// return employeeAndMultpleProjectDTO;
			} else {

			}
			
		}

		return finaldata;
	}

}
