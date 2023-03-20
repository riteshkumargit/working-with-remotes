package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Customer;
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
		
		Employee employee = (Employee) session.get(Employee.class, "AAA");
		Customer customer = (Customer) session.get(Customer.class, "BBB");
		
		System.out.println("Employee Details");
		System.out.println("------------------");
		System.out.println("Person Name       :"+employee.getPname());
		System.out.println("Person Address    :"+employee.getPaddr());
		System.out.println("Employee Id       :"+employee.getEid());
		System.out.println("Employee Salary   :"+employee.getEsal());
		System.out.println();
		
		System.out.println("Customer Details");
		System.out.println("------------------");
		System.out.println("Person Name       :"+customer.getPname());
		System.out.println("Person Address    :"+customer.getPaddr());
		System.out.println("Customer Id       :"+customer.getCid());
		System.out.println("Employee Mobile   :"+customer.getCmobile());
		System.out.println();
		session.close();
		sessionFactory.close();
	}

}
