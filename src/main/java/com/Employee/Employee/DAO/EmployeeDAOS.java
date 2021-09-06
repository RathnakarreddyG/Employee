package com.Employee.Employee.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Employee.Employee.models.EmployeeDetails;

public interface EmployeeDAOS extends JpaRepository<EmployeeDetails,Long> {

	@Query(value = "SELECT * FROM employee where department_id =?1 and  salary = (select max(salary) from employee)",nativeQuery = true)
	List<EmployeeDetails> findByEmployeeHighSalaryDepartmentWise(Long department_id);
}
