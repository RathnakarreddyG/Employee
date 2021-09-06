package com.Employee.Employee.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Employee.Employee.models.EmployeeAndProjects;

public interface EmployeeAndProjectsDAO extends JpaRepository<EmployeeAndProjects, Long> {
	
	@Query(value = "select * from employee_and_projects where emp_id =?1",nativeQuery = true)
	List<EmployeeAndProjects> findByEmpId(Long empId);

}
