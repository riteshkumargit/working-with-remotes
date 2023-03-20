package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) {
		
		Transaction transaction = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		try {
			
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry registry = builder.build();
			
			sessionFactory = configuration.buildSessionFactory(registry);
			session =  sessionFactory.openSession();
			
			Employee employee = new Employee();
			employee.setEno(666);
			employee.setEname("FFF");
			employee.setEsal(7000);
			employee.setEaddr("Pat");
			
			transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			System.out.println("Employee inserted successfully");
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			System.out.println("Employee insertion failure");
		} finally {
			session.close();
			sessionFactory.close();
		}

	}

}