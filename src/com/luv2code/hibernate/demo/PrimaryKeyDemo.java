package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
					
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student1 = new Student("John", "Saly", "saly@luv2code.com");
			Student student2 = new Student("Mary", "Pop", "pop@luv2code.com");
			Student student3 = new Student("Mi", "Wall", "wall@luv2code.com");
			
			session.beginTransaction();
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}

}
