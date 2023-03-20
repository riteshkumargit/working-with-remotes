package com.durga.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) throws Exception{
		
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry registry = builder.build();
			SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
			Session session = sessionFactory.openSession();
			
			Query query = session.createQuery("from Employee");
			
			Filter filter = session.enableFilter("empFilter");
			Scanner scanner = new Scanner(System.in);
			System.out.println("Employee Types");
			System.out.println("PERM");
			System.out.println("TEMP");
			System.out.print("Your Option     :");
			String etype = scanner.nextLine();
			filter.setParameter("type", etype);
			
			List<Employee> list = query.list();
			
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------");
			for (Employee employee : list) {
				System.out.println(employee.getEno()+"\t"+employee.getEname()+"\t"+employee.getEsal()+"\t"+employee.getEaddr()+"\t"+employee.getEtype());
			}
			
			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}