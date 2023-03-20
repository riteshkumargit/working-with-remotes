package com.durga.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Account;
import com.durga.entities.Address;
import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) throws Exception{
		
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			Configuration configuration = new Configuration();
			configuration.configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(configuration.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = configuration.buildSessionFactory(registry);
			session = sessionFactory.openSession();
			
			Account account = new Account();
			account.setAccNo("A111");
			account.setAccName("AAA");
			account.setAccType("Savings");
			
			Address address = new Address();
			address.setPno("23/3t");
			address.setStreet("MG Road");
			address.setCity("Hyd");
			
			Employee employee = new Employee();
			employee.setEno(111);
			employee.setEname("AAA");
			employee.setEsal(5000);
			employee.setEacc(account);
			employee.setEaddr(address);
			
			Transaction transaction = session.beginTransaction();
			session.save(account);
			session.save(address);
			session.save(employee);
			transaction.commit();
			System.out.println("Employee Inserted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}

	}

}