package com.Employee.Employee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Employee.models.Project;

public interface ProjectADAO extends JpaRepository<Project, Long> {

}
