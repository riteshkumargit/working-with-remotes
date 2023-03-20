package com.durga.test;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

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
		
		Criteria criteria = session.createCriteria(Employee.class);
		
		Criterion criterion1 = Restrictions.ge("esal", 5000.0f);
		Criterion criterion2 = Restrictions.le("esal", 8000.0f);
		
		criteria.add(criterion1);
		criteria.add(criterion2);
		
		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.property("eno"));
		projectionList.add(Projections.property("ename"));
		projectionList.add(Projections.property("esal"));
		projectionList.add(Projections.property("eaddr"));
		criteria.setProjection(projectionList);
		
		org.hibernate.criterion.Order order = org.hibernate.criterion.Order.desc("ename");
		criteria.addOrder(order);
		
		List<Object[]> list = criteria.list();
		System.out.println("ENO\tENAME\tESAL\tEADDR");
		System.out.println("--------------------------");
		for (Object[] obj : list) {
			
			System.out.print(obj[0]+"\t");
			System.out.print(obj[1]+"\t");
			System.out.print(obj[2]+"\t");
			System.out.println(obj[3]);
			
		}
		session.close();
		sessionFactory.close();
	}

}