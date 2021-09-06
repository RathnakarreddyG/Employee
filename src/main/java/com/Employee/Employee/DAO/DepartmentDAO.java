package com.Employee.Employee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Employee.models.Department;

public interface DepartmentDAO extends JpaRepository<Department, Long> {

}
