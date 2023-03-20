package com.durga.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Employee");
		System.out.println("Using list() method");
		System.out.println("----------------------");
		
		List<Employee> list = query.list();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("-------------------------");
		for (Employee employee : list) {
			System.out.print(employee.getEno()+"\t");
			System.out.print(employee.getEname()+"\t");
			System.out.print(employee.getEsal()+"\t");
			System.out.println(employee.getEaddr());
		}
		System.out.println();
		
		System.out.println("Using iterator() method");
		System.out.println("==========================");
		Iterator<Employee> iterator = query.iterate();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("==========================");
		while(iterator.hasNext()) {
			Employee employee = iterator.next();
			System.out.print(employee.getEno()+"\t");
			System.out.print(employee.getEname()+"\t");
			System.out.print(employee.getEsal()+"\t");
			System.out.println(employee.getEaddr());
		}
		System.out.println();
		
		System.out.println("Using scroll() method");
		System.out.println("************************");
		ScrollableResults results = query.scroll();
		
		System.out.println("Employee Details in Forward Direction");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("***************************************");
		while(results.next()) {
			Object[] obj = results.get();
			for (Object object : obj) {
				Employee employee = (Employee)object;
				System.out.print(employee.getEno()+"\t");
				System.out.print(employee.getEname()+"\t");
				System.out.print(employee.getEsal()+"\t");
				System.out.println(employee.getEaddr());
			}
		}
		
		System.out.println("Employee Details in Backward Direction");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("***************************************");
		while(results.previous()) {
			Object[] obj = results.get();
			for (Object object : obj) {
				Employee employee = (Employee)object;
				System.out.print(employee.getEno()+"\t");
				System.out.print(employee.getEname()+"\t");
				System.out.print(employee.getEsal()+"\t");
				System.out.println(employee.getEaddr());
			}
		}
		System.out.println();
		
		System.out.println("Using uniqueResult() method");
		System.out.println("----------------------------");
		Query query1 = session.createQuery("from Employee where eno =111 ");
		
		Object result = query1.uniqueResult();
		Employee employee = (Employee) result;
		System.out.println("Employee Details");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("-------------------");
		System.out.print(employee.getEno()+"\t");
		System.out.print(employee.getEname()+"\t");
		System.out.print(employee.getEsal()+"\t");
		System.out.println(employee.getEaddr());
		
		
		
		session.close();
		sessionFactory.close();
		
		
		
	}

}