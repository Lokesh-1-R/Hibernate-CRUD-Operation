package com.sr.dao;

import java.util.List;

import com.sr.entity.Employee;

public interface EmployeeDAO {

	public int saveEmployee(String Name,int age,long salary);
	public List<Employee> getAllEmployee();
	public Employee getAllEmployeeById(int id);

	public void updateEmployee(int id,long salary);
	public void deleteEmployee(int id);
}
