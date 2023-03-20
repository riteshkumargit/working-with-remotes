package com.durga.test;

import java.util.List;

import org.hibernate.Query;
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
		
		Query namedQuery = session.getNamedQuery("getEmployeesFunc");
		
		List<Employee> list = namedQuery.list();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("-----------------------------");
		for (Employee employee : list) {
			System.out.print(employee.getEno()+"\t");
			System.out.print(employee.getEname()+"\t");
			System.out.print(employee.getEsal()+"\t");
			System.out.println(employee.getEaddr());
		}
		
		session.close();
		sessionFactory.close();
	}

}