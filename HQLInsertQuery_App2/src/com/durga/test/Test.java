package com.durga.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) throws Exception{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("insert into Employee2(eno,ename,esal,eaddr)select e.eno,e.ename,e.esal,e.eaddr from Employee1 as e");
		Transaction transaction = session.beginTransaction();
		int rowCount = query.executeUpdate();
		transaction.commit();
		System.out.println("Employee details are transfered from emp1 to emp2");
		session.close();
		sessionFactory.close();

	}

}