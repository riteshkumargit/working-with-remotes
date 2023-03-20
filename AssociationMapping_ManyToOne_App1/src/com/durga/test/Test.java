package com.durga.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.durga.entities.Branch;
import com.durga.entities.Student;

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
		Branch branch = new Branch();
		branch.setBid("B-111");;
		branch.setBname("CS");
		
		
		
		Student student1 = new Student();
		student1.setSid("S-111");
		student1.setSname("AAA");
		student1.setSaddr("Hyd");
		student1.setBranch(branch);
		
		Student student2 = new Student();
		student2.setSid("S-222");
		student2.setSname("BBB");
		student2.setSaddr("Hyd");
		student2.setBranch(branch);
		
		Student student3 = new Student();
		student3.setSid("S-333");
		student3.setSname("CCC");
		student3.setSaddr("Hyd");
		student3.setBranch(branch);
		
		
		Transaction transaction = session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.save(student3);
		transaction.commit();
		System.out.println("Employee Inserted Successfully");
		*/
		
		
		Student student1 = (Student) session.get(Student.class, "S-111");
		System.out.println("Student1 Details");
		System.out.println("-------------------");
		System.out.println("Student Number      :"+student1.getSid());
		System.out.println("Student Name        :"+student1.getSname());
		System.out.println("Student Address     :"+student1.getSaddr());
		
		Branch branch1 = student1.getBranch();
		System.out.println("Branch Details");
		System.out.println("-------------------");
		System.out.println("Branch Id     :"+branch1.getBid());
		System.out.println("Branch Name   :"+branch1.getBname());
		
		Student student2 = (Student) session.get(Student.class, "S-222");
		System.out.println("Student1 Details");
		System.out.println("-------------------");
		System.out.println("Student Number      :"+student2.getSid());
		System.out.println("Student Name        :"+student2.getSname());
		System.out.println("Student Address     :"+student2.getSaddr());
		
		Branch branch2 = student2.getBranch();
		System.out.println("Branch Details");
		System.out.println("-------------------");
		System.out.println("Branch Id     :"+branch2.getBid());
		System.out.println("Branch Name   :"+branch2.getBname());
		
		Student student3 = (Student) session.get(Student.class, "S-111");
		System.out.println("Student1 Details");
		System.out.println("-------------------");
		System.out.println("Student Number      :"+student3.getSid());
		System.out.println("Student Name        :"+student3.getSname());
		System.out.println("Student Address     :"+student3.getSaddr());
		
		Branch branch3 = student3.getBranch();
		System.out.println("Branch Details");
		System.out.println("-------------------");
		System.out.println("Branch Id     :"+branch3.getBid());
		System.out.println("Branch Name   :"+branch3.getBname());
		session.close();
		sessionFactory.close();
	}

}
