package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Account;

public class Test {

	public static void main(String[] args) {
		
		Configuration oracleConfiguration =null;
		Configuration mysqlconfiguration = null;
		
		SessionFactory oracleSessionFactory = null;
		SessionFactory mysqlSessionFactory = null;
		
		Session oracleSession = null;
		Session mysqlSession = null;
		
		Transaction oracleTransaction = null;
		Transaction mysqlTransaction = null;
		
		try {
			oracleConfiguration = new Configuration();
			oracleConfiguration.configure("oracle_cfg.xml");
			mysqlconfiguration = new Configuration();
			mysqlconfiguration.configure("mysql_cfg.xml");
			
			StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder();
			builder = builder.applySettings(oracleConfiguration.getProperties());
			StandardServiceRegistry oracleRegistry = builder.build();
			oracleSessionFactory = oracleConfiguration.buildSessionFactory(oracleRegistry);
			
			builder = builder.applySettings(mysqlconfiguration.getProperties());
			StandardServiceRegistry mysqlRegistry = builder.build();
			mysqlSessionFactory = mysqlconfiguration.buildSessionFactory(mysqlRegistry);
			
			oracleSession = oracleSessionFactory.openSession();
			mysqlSession = mysqlSessionFactory.openSession();
			
			Account source_Account = (Account) oracleSession.get("com.durga.entities.Account", "abc123");
			int source_Balance = 0;
			source_Balance = source_Account.getBalance();
			source_Balance = source_Balance - 5000;
			source_Account.setBalance(source_Balance);
			
			Account target_Account = (Account) mysqlSession.get("com.durga.entities.Account", "xyz123");
			int target_Balance = 0;
			target_Balance = target_Account.getBalance();
			target_Balance = target_Balance + 5000;
			target_Account.setBalance(target_Balance);
			
			oracleTransaction = oracleSession.beginTransaction();
			mysqlTransaction = mysqlSession.beginTransaction();
			
			oracleSession.update(source_Account);
			mysqlSession.update(target_Account);
			
			oracleTransaction.commit();
			mysqlTransaction.commit();
			
			System.out.println("Rs 5000 transfered from "+source_Account.getAccNo()+" to "+target_Account.getAccNo());
			System.out.println("Transaction Success");
			
		} catch (Exception e) {
			e.printStackTrace();
			oracleTransaction.rollback();
			mysqlTransaction.rollback();
			System.out.println("Transaction Failure");
			
			
		}finally {
			oracleSession.close();
			mysqlSession.close();
			oracleSessionFactory.close();
			mysqlSessionFactory.close();
		}
	}

}

