package com.durga.service;

import com.durga.dao.EmployeeDao;
import com.durga.entities.Employee;
import com.durga.factories.EmployeeDaoFactory;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String addEmployee(Employee employee) {
		EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
		String status = employeeDao.add(employee);
		return status;
	}

	@Override
	public Employee searchEmployee(int eno) {
		EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
		Employee employee = employeeDao.search(eno);
		return employee;
	}

	@Override
	public String updateEmployee(Employee employee) {
		String status = "";
		EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
		status = employeeDao.update(employee);
		return status;
	}

	@Override
	public String deleteEmployee(int eno) {
		String status = "";
		EmployeeDao employeeDao = EmployeeDaoFactory.getEmployeeDao();
		status = employeeDao.delete(eno);
		return status;
	}

}
