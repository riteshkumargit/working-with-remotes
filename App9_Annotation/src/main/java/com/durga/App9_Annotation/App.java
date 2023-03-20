package com.durga.App9_Annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.durga.App9_Annotation.entities.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = null;
        Session session = null;
        
        try {
			Configuration configuration = new Configuration();
			configuration.configure();
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			Employee employee = (Employee) session.get(Employee.class, 111);
			if(employee == null) {
				System.out.println("Employee is not Existed");
			}else {
				System.out.println("Employee Details    :");
				System.out.println("=======================");
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