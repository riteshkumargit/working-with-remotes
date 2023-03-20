package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Transaction transaction = session.beginTransaction();
		Employee employee = (Employee)session.get(Employee.class, 111);
		System.out.println("Employee Number    :"+employee.getEno());
		System.out.println("Employee Name      :"+employee.getEname());
		System.out.println("Employee Salary    :"+employee.getEsal());
		System.out.println("Employee Address   :"+employee.getEaddr());
		
		session.close();
		sessionFactory.close();

	}

}
