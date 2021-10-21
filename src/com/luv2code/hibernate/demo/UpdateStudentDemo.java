package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure().addAnnotatedClass(Student.class).buildSessionFactory();
					
		Session session = factory.getCurrentSession();
		
		try {
			
//			int studentId = 2;
			session = factory.getCurrentSession();
			session.beginTransaction();

//			Student student = session.get(Student.class, studentId);
//			session.delete(student);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			
			
					
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}
	
}
