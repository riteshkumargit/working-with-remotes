package com.durga.test;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) throws Exception{

		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		
		SQLQuery sqlQuery = session.createSQLQuery("select eno,ename,esal from emp1");
		List<Object[]> list = sqlQuery.list();
		System.out.println("ENO\tENAME\tESAL");
		System.out.println("-------------------------");
		for (Object[] obj : list) {
			System.out.print(obj[0]+"\t");
			System.out.print(obj[1]+"\t");
			System.out.println(obj[2]+"\t");
			//System.out.println(obj[3]);
		}
		
		session.close();
		sessionFactory.close();
	}

}