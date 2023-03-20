package com.durga.App8.factories;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessFactory {

	private static Session session;
	
	static {
		session = new Configuration().configure().buildSessionFactory().openSession();
	}
	
	public static Session getSession() {
		return session;
	}
	
	public static void closeSession() {
		session.close();
	}
}
