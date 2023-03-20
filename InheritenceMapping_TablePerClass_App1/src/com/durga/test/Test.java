package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.EmployeeAccount;
import com.durga.entities.StudentAccount;

public class Test {

	public static void main(String[] args) throws Exception{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		
		StudentAccount studentAccount = new StudentAccount();
		studentAccount.setAccNo("A-111");
		studentAccount.setAccName("AAA");
		studentAccount.setAccType("Savings");
		studentAccount.setSid("S-111");
		studentAccount.setSbranch("CS");
		studentAccount.setMarks(77);
		
		EmployeeAccount employeeAccount = new EmployeeAccount();
		employeeAccount.setAccNo("A-222");
		employeeAccount.setAccName("EEE");
		employeeAccount.setAccType("Savings");
		employeeAccount.setEid("E-222");
		employeeAccount.setEsal(5000);
		employeeAccount.setEaddr("Hyd");
		
		Transaction transaction = session.beginTransaction();
		session.save(studentAccount);
		session.save(employeeAccount);
		transaction.commit();
		System.out.println("Student Account Inserted Successfully");
		System.out.println("Employee Account Inserted Successfully");

		
	}

}