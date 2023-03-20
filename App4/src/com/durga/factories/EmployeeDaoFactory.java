package com.durga.factories;

import com.durga.dao.EmployeeDao;
import com.durga.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {

	private static EmployeeDao employeeDao;
	
	static {
		employeeDao = new EmployeeDaoImpl();
	}
	
	public static EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
}
