package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durga.entity.Employee;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Employee employee = (Employee) session.get("com.durga.entity.Employee",111);
		//Employee employee = (Employee) session.load("com.durga.entity.Employee",222);
		Employee employee = (Employee) session.load(Employee.class,222);

		System.out.println(employee);
		System.out.println("Employe Details");
		System.out.println("------------------------------");
		System.out.println("Employee Number    : "+employee.getEno());
		System.out.println("Employee Name    : "+employee.getEname());
		System.out.println("Employee Salary    : "+employee.getEsal());
		System.out.println("Employee Address    : "+employee.getEaddr());
		
		session.close();
		sessionFactory.close();
	}
}
