package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durga.entity.Employee;

public class Test {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("myconfig.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee employee = new Employee();
		employee.setEno(111);
		employee.setEname("AAA");
		employee.setEsal(5000);
		employee.setEaddr("HYD");
		
		Transaction transaction = session.beginTransaction();
		
		//session.update(employee);
		
		//session.saveOrUpdate(employee);
		
		session.delete(employee);
		transaction.commit();
		
		//System.out.println("Employee Updated Successfully");
		System.out.println("Employee Deleted Successfully");
		session.close();
		sessionFactory.close();
	}

}
