package com.durga.service;

import com.durga.entities.Employee;

public interface EmployeeService {

	public String addEmployee(Employee employee);
	
	public Employee searchEmployee(int eno);
	
	public String updateEmployee(Employee employee);
	
	public String deleteEmployee(int eno);
}
