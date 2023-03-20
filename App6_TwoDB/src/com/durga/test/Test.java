package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) {
		
		try {
			Configuration oracleConfiguration = new Configuration();
			oracleConfiguration.configure("hibernate_oracle_cfg.xml");
			
			Configuration mysqlConfiguration = new Configuration();
			mysqlConfiguration.configure("hibernate_mysql_cfg.xml");
			
			SessionFactory oracleSessionFactory = oracleConfiguration.buildSessionFactory();
			SessionFactory mysqlSessionFactory = mysqlConfiguration.buildSessionFactory();
			
			Session oracleSession = oracleSessionFactory.openSession();
			Session mysqlSession = mysqlSessionFactory.openSession();
			
			Employee employee = (Employee) oracleSession.get(Employee.class, 222);
			
			Transaction transaction = mysqlSession.beginTransaction();
			
			int primaryKey = (int) mysqlSession.save(employee);
			transaction.commit();
			if(primaryKey == 222) {
				System.out.println("Employee Transfered from Oracle to MySql");
			}else {
				System.out.println("Employee does not transfered from Oracle to MySql");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
