package com.hibernatedemo.hibernatedeom;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatedemo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			//create a transaction
			session.beginTransaction();

			//query the students
//			List<Student> theStudents = session.createQuery("from Student").getResultList(); // or .list();
			
//			List<Student> theStudents = session.createQuery("from Student s where s.lastName='singh'").getResultList();
			
			List<Student> theStudents = session.createQuery("from Student s where s.lastName='singh'"+" and s.firstName like '%l'").getResultList();
			
			//display the students
			theStudents.forEach(System.out::println);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
