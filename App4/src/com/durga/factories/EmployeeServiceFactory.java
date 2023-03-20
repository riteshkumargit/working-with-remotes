package com.durga.factories;

import com.durga.service.EmployeeService;
import com.durga.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {

	private static EmployeeService employeeService;
	
	static {
		employeeService = new EmployeeServiceImpl();
	}
	
	public static EmployeeService getEmployeeService() {
		return employeeService;
	}
}
