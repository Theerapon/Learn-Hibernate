package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
					
		Session session = factory.getCurrentSession();
		
		try {
			

			session.beginTransaction();

			List<Student> students = session.createQuery("from Student").list();
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName='nanoi'").list();
			System.out.println();
			displayStudents(students);
			
			students = session.createQuery("from Student s where" + 
					" s.lastName='nanoi' OR s.firstName='mi'").list();
			System.out.println();
			displayStudents(students);
			
			students = session.createQuery("from Student s where" + 
					" s.email LIKE '%luv2code.com'").list();
			System.out.println();
			displayStudents(students);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}
	
}
