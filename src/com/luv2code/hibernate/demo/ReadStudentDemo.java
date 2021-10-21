package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
					
		Session session = factory.getCurrentSession();
		
		try {
			
			Student student = new Student("fakie", "nanoi", "nanoi@luv2code.com");
			
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("\n Getting student with id: " + student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Get complete: " + myStudent);
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}
	
}
