package com.durga.App11_WithoutConfigAndMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durga.App11_WithoutConfigAndMapping.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	
    	SessionFactory sessionFactory = null;
    	Session session = null;
    	
    	try {
			Configuration configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/durgadb");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "root");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			configuration.setProperty("show_sql", "true");
			configuration.addAnnotatedClass(Employee.class);
			
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Employee employee = (Employee) session.get(Employee.class, 222);
			if(employee == null) {
				System.out.println("Employee Not Existed");
			}else {
				System.out.println("Employee Details ");
				System.out.println("====================");
				System.out.println("Employee Number     :"+employee.getEno());
				System.out.println("Employee Name       :"+employee.getEname());
				System.out.println("Employee Salary     :"+employee.getEsal());
				System.out.println("Employee Address    :"+employee.getEaddr());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
    
    }
}
