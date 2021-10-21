package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
					
		Session session = factory.getCurrentSession();
		
		try {
			
			int studentId = 1;
			session = factory.getCurrentSession();
			session.beginTransaction();

			Student student = session.get(Student.class, studentId);
			student.setFirstName("First");
			
			session.getTransaction().commit();
			
			// update email for all student
			session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("update Student set email='fake@demoemail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}
	
}
