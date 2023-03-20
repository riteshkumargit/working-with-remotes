package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durga.entity.Employee;

public class Test {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee employee = new Employee();
		employee.setEno(777);
		employee.setEname("CCC");
		employee.setEsal(8000);
		employee.setEaddr("Hyd");
		
		Transaction transaction = session.beginTransaction();
		
		//int save = (int)session.save(employee);
		//System.out.println(save);
		
		session.persist(employee);
		
		transaction.commit();
		
		System.out.println();
		
		System.out.println("Employee inserted successfully");
		
		session.close();
		sessionFactory.close();

	}

}
