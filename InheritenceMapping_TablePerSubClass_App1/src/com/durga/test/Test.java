package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.CardPayment;
import com.durga.entities.ChequePayment;

public class Test {

	public static void main(String[] args) throws Exception{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		
		CardPayment cardPayment = new CardPayment();
		cardPayment.setTx_id("t-111");
		cardPayment.setPaymentDate("16/1/23");
		cardPayment.setPaymentAmt(5000);
		cardPayment.setCardNo(1234);
		cardPayment.setExprDate("23/3/25");
		
		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setTx_id("t-222");
		chequePayment.setPaymentDate("18/1/23");
		chequePayment.setPaymentAmt(7000);
		chequePayment.setChequeNo(2345);
		chequePayment.setAccNo("A-222");
		
		Transaction transaction = session.beginTransaction();
		session.save(cardPayment);
		session.save(chequePayment);
		transaction.commit();
		
		System.out.println("Card Payement Stored Successfully");
		System.out.println("Cheque Payment Stored Successfully");
		
		session.close();
		sessionFactory.close();
	}
}