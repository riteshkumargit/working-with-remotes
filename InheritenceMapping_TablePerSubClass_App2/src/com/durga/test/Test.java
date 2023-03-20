package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.CardPayment;
import com.durga.entities.ChequePayment;
import com.durga.entities.Payment;

public class Test {

	public static void main(String[] args) throws Exception{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		
		CardPayment cardPayment = (CardPayment) session.get(Payment.class, "t-111");
		System.out.println("Card Payment Details");
		System.out.println("-----------------------");
		System.out.println("Transaction Id     :"+cardPayment.getTx_id());
		System.out.println("Payment Date       :"+cardPayment.getPaymentDate());
		System.out.println("Payment Amount     :"+cardPayment.getPaymentAmt());
		System.out.println("Card Number        :"+cardPayment.getCardNo());
		System.out.println("Expiry date        :"+cardPayment.getExprDate());
		System.out.println();
		
		ChequePayment chequePayment =  (ChequePayment) session.get(Payment.class, "t-222");
		System.out.println("Cheque Payment Details");
		System.out.println("-----------------------");
		System.out.println("Transaction Id     :"+chequePayment.getTx_id());
		System.out.println("Payment Date       :"+chequePayment.getPaymentDate());
		System.out.println("Payment Amount     :"+chequePayment.getPaymentAmt());
		System.out.println("Cheque Number        :"+chequePayment.getChequeNo());
		System.out.println("Account Number        :"+chequePayment.getAccNo());
		session.close();
		sessionFactory.close();
	}
}