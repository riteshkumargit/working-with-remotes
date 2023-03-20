package com.durga.hbm4.test;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.hbm4.entities.Employee;

public class Test {

	public static void main(String[] args) throws Exception{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		Properties properties =  configuration.getProperties();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(properties);
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get("com.durga.hbm4.entities.Employee", 222);
		if(employee == null) {
			System.out.println("Employee Not Existed...");
		}else {
			System.out.println("Employee Details     :");
			System.out.println("-------------------------");
			System.out.println("Employee Number      :"+employee.getEno());
			System.out.println("Employee Name        :"+employee.getEname());
			System.out.println("Employee Salary      :"+employee.getEsal());
			System.out.println("Employee Address     :"+employee.getEaddr());
		}
		session.close();
		sessionFactory.close();
	}

}
