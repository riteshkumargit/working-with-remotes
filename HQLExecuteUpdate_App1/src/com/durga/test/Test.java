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
		
		Query query = session.createQuery("update Employee set esal = esal+500 where esal<10000");
		Transaction transaction = session.beginTransaction();
		int rowCount = query.executeUpdate();
		transaction.commit();
		System.out.println("No of records updated :"+rowCount);
		
		Query query2 = session.createQuery("delete from Employee where esal < 11000");
		Transaction transaction2 = session.beginTransaction();
		int rowCount1 = query2.executeUpdate();
		transaction2.commit();
		System.out.println("No of records deleted :"+rowCount1);
		session.close();
		sessionFactory.close();
	}
}