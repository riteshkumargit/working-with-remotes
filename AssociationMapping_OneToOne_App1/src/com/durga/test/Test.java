package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Account;
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
		
		/*
		Account account = new Account();
		account.setAccNo("abc123");
		account.setAccName("Durga");
		account.setAccType("Savings");
		
		
		Employee employee = new Employee();
		employee.setEid("E-111");
		employee.setEname("Durga");
		employee.setEsal(25000);
		employee.setEaddr("Hyd");
		employee.setAccount(account);
		
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		System.out.println("Employee Inserted Successfully");
		*/
		
		
		Employee employee = (Employee) session.get(Employee.class, "E-111");
		System.out.println("Employee Details");
		System.out.println("-------------------");
		System.out.println("Employee Number     :"+employee.getEid());
		System.out.println("Employee Name       :"+employee.getEname());
		System.out.println("Employee Salary     :"+employee.getEsal());
		System.out.println("Employee Address    :"+employee.getEaddr());
		System.out.println();
		Account account = employee.getAccount();
		System.out.println("Employee Details");
		System.out.println("-------------------");
		System.out.println("Account Number     :"+account.getAccNo());
		System.out.println("Account Name       :"+account.getAccName());
		System.out.println("Account Type       :"+account.getAccType());
		session.close();
		sessionFactory.close();
	}

}
