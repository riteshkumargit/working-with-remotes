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
		
		Employee employee = new Employee();
		employee.setPname("AAA");
		employee.setPaddr("Hyd");
		employee.setEid("E-111");
		employee.setEsal(5000);
		
		Customer customer = new Customer();
		customer.setPname("BBB");
		customer.setPaddr("Hyd");
		customer.setCid("C-111");
		customer.setCmobile("91-7677344326");

		Transaction transaction = session.beginTransaction();
		session.save(employee);
		session.save(customer);
		transaction.commit();
		
		System.out.println("Employee Object Inserted successfully");
		System.out.println("Customer Object Inserted successfully");
		
		session.close();
		sessionFactory.close();
	}

}
