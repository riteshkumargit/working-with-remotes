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
			
			Employee employee = (Employee)session.get(com.durga.entities.Employee.class, 111);
			
			System.out.println("Employee Details");
			System.out.println("------------------");
			System.out.println("Employee Number   :"+employee.getEno());
			System.out.println("Employee Name     :"+employee.getEname());
			System.out.println("Employee Salary   :"+employee.getEsal());
			System.out.println();
			
			Account eacc = employee.getEacc();
			System.out.println("Account Details");
			System.out.println("-----------------");
			System.out.println("Account Number     :"+eacc.getAccNo());
			System.out.println("Account Name       :"+eacc.getAccName());
			System.out.println("Account Type       :"+eacc.getAccType());
			System.out.println();
			
			Address eaddr = employee.getEaddr();
			System.out.println("Address Details");
			System.out.println("-----------------");
			System.out.println("PNO     :"+eaddr.getPno());
			System.out.println("Street  :"+eaddr.getStreet());
			System.out.println("City    :"+eaddr.getCity());			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}

	}

}