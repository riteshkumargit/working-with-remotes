package com.durga.dao;

import com.durga.entities.Employee;

public interface EmployeeDao {

	public String add(Employee employee);
	
	public Employee search(int eno);
	
	public String update(Employee employee);
	
	public String delete(int eno);
}
