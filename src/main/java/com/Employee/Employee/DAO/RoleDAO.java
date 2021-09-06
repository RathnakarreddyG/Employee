package com.Employee.Employee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.Employee.models.Roles;

public interface RoleDAO extends JpaRepository<Roles, Long> {

}
