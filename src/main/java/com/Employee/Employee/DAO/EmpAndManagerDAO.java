package com.Employee.Employee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Employee.Employee.models.EmpAndManger;

public interface EmpAndManagerDAO extends JpaRepository<EmpAndManger, Long> {
	
	@Query(value = "select * from emp_manager where emp_id =?1",nativeQuery = true)
	EmpAndManger findByEmpId(Long emp_id);

}
