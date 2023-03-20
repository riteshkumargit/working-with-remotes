package com.durga.App7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durga.App7.entities.Employee;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    
    	Configuration configuration = new Configuration();
    	configuration.configure();
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	Session session = sessionFactory.openSession();
    	
    	//Transaction transaction = session.beginTransaction();
    	
    	Employee employee = (Employee) session.get(Employee.class, 222);
    	System.out.println("Employee Details    :");
    	System.out.println("=======================");
    	System.out.println("Employee Number    :"+employee.getEno());
    	System.out.println("Employee Name      :"+employee.getEname());
    	System.out.println("Employee Salary    :"+employee.getEsal());
    	System.out.println("Employee address   :"+employee.getEaddr());
    	
    	session.close();
    	sessionFactory.close();
    	
    }
}
