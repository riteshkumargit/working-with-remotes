package com.durga.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Department;
import com.durga.entities.Employee;

public class Test {

	public static void main(String[] args) throws Exception{
		
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder = builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(registry);
		Session session = sessionFactory.openSession();
		
		/*
		Employee emp1 = new Employee("E-111","AAA",5000,"Hyd");
		Employee emp2 = new Employee("E-222","BBB",6000,"Hyd");
		Employee emp3 = new Employee("E-333","CCC",7000,"Hyd");
		Employee emp4 = new Employee("E-444","DDD",8000,"Hyd");
		Employee emp5 = new Employee("E-555","EEE",9000,"Hyd");
		Employee emp6 = new Employee("E-666","FFF",10000,"Hyd");
		
		Set<Employee> emps = new HashSet<Employee>();
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		emps.add(emp6);
		
		Department department = new Department();
		department.setDid("D-111");
		department.setDname("Admin");
		department.setEmps(emps);
		Transaction transaction = session.beginTransaction();
		session.save(department);
		transaction.commit();
		System.out.println("Department Inserted Successfully");
		*/
		
		
		Department department = (Department) session.get(Department.class, "D-111");
		System.out.println("Department Details");
		System.out.println("-------------------");
		System.out.println("Department Number     :"+department.getDid());
		System.out.println("Department Name       :"+department.getDname());
		Set<Employee> emps = department.getEmps();
		System.out.println("Employee Details");
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("------------------");
		for (Employee employee : emps) {
			System.out.print(employee.getEid()+"\t");
			System.out.print(employee.getEname()+"\t");
			System.out.print(employee.getEsal()+"\t");
			System.out.print(employee.getEaddr()+"\n");
		}
		
		session.close();
		sessionFactory.close();
	}

}