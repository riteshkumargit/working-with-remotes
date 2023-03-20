package com.durga.App13_ConfigInDiffProperties;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durga.App13_ConfigInDiffProperties.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    
    	SessionFactory sessionFactory = null;
    	Session session = null;
    	
    	try {
			Configuration configuration = new Configuration();
			FileInputStream fileInputStream = new FileInputStream("D:\\Hibernate_NB\\App13_ConfigInDiffProperties\\resources\\config.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			configuration.addResource("Employee.hbm.xml");
			configuration.setProperties(properties);
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			Employee employee = (Employee) session.get(Employee.class, 222);
			if(employee == null) {
				System.out.println("Employee Not Existed ");
			}else {
				System.out.println("Employee Details");
				System.out.println("===================");
				System.out.println("Employee Number    :"+employee.getEno());
				System.out.println("Employee Name      :"+employee.getEname());
				System.out.println("Employee Salary    :"+employee.getEsal());
				System.out.println("Employee Address   :"+employee.getEaddr());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
    }
}
