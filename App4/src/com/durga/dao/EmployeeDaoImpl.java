package com.durga.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.durga.entities.Employee;
import com.durga.factories.SessFactory;

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Override
	public String add(Employee employee) {
		
		String status = "";
		
		try {
			Session session = SessFactory.getSession();
			Employee emp = (Employee)session.get(Employee.class, employee.getEno());
			if(emp == null) {
				Transaction beginTransaction = session.beginTransaction();
				int saveEmployee = (int)session.save(employee);
				beginTransaction.commit();
				if(saveEmployee == employee.getEno()) {
					status = "Success";
				}else {
					status = "Failure";
				}
			}else {
				status = "Existed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Employee search(int eno) {
		Employee employee = null;
		
		try {
			Session session = SessFactory.getSession();
			employee = (Employee)session.get(Employee.class, eno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public String update(Employee employee) {
		
		String status = "";
		try {
			Session session = SessFactory.getSession();
			Transaction transaction = session.beginTransaction();
			session.update(employee);
			transaction.commit();
			status = "Success";
		} catch (Exception e) {
			status = "Failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(int eno) {
		
		String status = "";
		
		try {
			Session session = SessFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Employee employee = new Employee();
			employee.setEno(eno);
			session.delete(employee);
			transaction.commit();
			status = "Sucees";
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}

}
