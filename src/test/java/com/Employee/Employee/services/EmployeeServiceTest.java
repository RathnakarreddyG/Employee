package com.Employee.Employee.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Employee.Employee.DAO.DepartmentDAO;
import com.Employee.Employee.DAO.RoleDAO;
import com.Employee.Employee.models.Department;
import com.Employee.Employee.models.Roles;

@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	
	@MockBean
	private DepartmentDAO departmentDAO;
	
	@MockBean
	private RoleDAO roleDao;
	
	@Test
	public void testAddRole() {
		Roles roles = new Roles((long)1,"Employee",LocalDate.now());
		when(roleDao.save(roles)).thenReturn(roles);
		assertEquals(roles, roleDao.save(roles));
		
	}
	
	@Test
	public void testAddDepartment() {
		Department department = new Department((long) 1,"Marketing");
		when(departmentDAO.save(department)).thenReturn(department);
		assertEquals(department, employeeService.addDeprtment(department));
	}
	

}
