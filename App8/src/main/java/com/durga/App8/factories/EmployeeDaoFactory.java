package com.durga.App8.factories;

import com.durga.App8.dao.EmployeeDao;
import com.durga.App8.dao.EmployeedaoImpl;

public class EmployeeDaoFactory {

	private static EmployeeDao employeeDao;
	
	static {
		employeeDao = new EmployeedaoImpl();
	}
	
	public static EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
}
