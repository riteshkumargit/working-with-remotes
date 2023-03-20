package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Account;
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
		
		StudentAccount studentAccount = (StudentAccount) session.get(Account.class, "A-111");
		System.out.println("Student Account Details");
		System.out.println("-------------------------");
		System.out.println("Account Number     :"+studentAccount.getAccNo());
		System.out.println("Account Name       :"+studentAccount.getAccName());
		System.out.println("Account Type       :"+studentAccount.getAccType());
		System.out.println("Student Number     :"+studentAccount.getSid());
		System.out.println("Student Branch     :"+studentAccount.getSbranch());
		System.out.println("Student Marks      :"+studentAccount.getMarks());
		
		EmployeeAccount employeeAccount = (EmployeeAccount) session.get(Account.class, "A-222");
		System.out.println("Employee Account Details");
		System.out.println("-------------------------");
		System.out.println("Account Number      :"+employeeAccount.getAccNo());
		System.out.println("Account Name        :"+employeeAccount.getAccName());
		System.out.println("Account Type        :"+employeeAccount.getAccType());
		System.out.println("Employee Number     :"+employeeAccount.getEid());
		System.out.println("Student Salary      :"+employeeAccount.getEsal());
		System.out.println("Student Address     :"+employeeAccount.getEaddr());	
		
		session.close();
		sessionFactory.close();
	}

}