package com.durga.hbmver4;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.hbmver4.entities.Employee;

public class App 
{
    public static void main( String[] args ) throws Exception{
        
    	Configuration configuration = new Configuration();
    	configuration.configure();
    	configuration.addAnnotatedClass(com.durga.hbmver4.entities.Employee.class);
    	
    	Properties properties = configuration.getProperties();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
    	builder = builder.applySettings(properties);
    	StandardServiceRegistry registry = builder.build();
    	SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
    	Session session =  sessionFactory.openSession();
    	Employee employee = (Employee) session.get("com.durga.hbmver4.entities.Employee", 111);
    	
    	if(employee == null) {
    		System.out.println("Employee Not Exixted....");
    	}else {
    		System.out.println("Employee Details      :");
    		System.out.println("------------------------");
    		System.out.println("Employee Number       :"+employee.getEno());
    		System.out.println("Employee Name         :"+employee.getEname());
    		System.out.println("Employee Salary       :"+employee.getEsal());
    		System.out.println("Employee Address      :"+employee.getEaddr());
    	}
    	sessionFactory.close();
    	session.close();
    }
}
