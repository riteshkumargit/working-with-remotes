package com.durga.App8.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.durga.App8.entities.Employee;
import com.durga.App8.factories.SessFactory;

public class EmployeedaoImpl implements EmployeeDao {

	@Override
	public String add(Employee employee) {
		String status = "";
		try {
			Session session = SessFactory.getSession();
			Transaction transaction = session.beginTransaction();
			Employee emp = (Employee) session.get(Employee.class, employee.getEno());
			if(emp == null) {
				int pkval = (int) session.save(employee);
				transaction.commit();
				
				if(pkval == employee.getEno()) {
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

}
