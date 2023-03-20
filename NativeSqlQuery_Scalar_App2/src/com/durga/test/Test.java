package com.durga.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		
		Query namedQuery = session.getNamedQuery("scalarSqlQuery");
		namedQuery.setFloat(0, 5000);
		namedQuery.setFloat("maxSal", 8000);
		List<Object[]> list = namedQuery.list();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("-----------------------------");
		for (Object[] obj : list) {
			System.out.print(obj[0]+"\t");
			System.out.print(obj[1]+"\t");
			System.out.print(obj[2]+"\t");
			System.out.println(obj[3]);
		}
		
		session.close();
		sessionFactory.close();
	}

}