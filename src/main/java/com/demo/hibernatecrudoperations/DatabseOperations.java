package com.demo.hibernatecrudoperations;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.demo.hibernatecrudoperations.HibernateUtils;

public class DatabseOperations {
	public final static Logger logger = Logger.getLogger(DatabseOperations.class);
	public static void createData()
	{
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		Session session = sFactory.openSession();
		Transaction tr = session.beginTransaction();
		Student stud=null;
		int count=0;
		try{
			for(int i=101;i<110;i++){
				count++;
				stud=new Student();
				stud.setStudRollNo(i);
				stud.setStudName("Student"+i);
				stud.setStudDegree("BE COMP");
				session.save(stud);
				logger.info("\nSuccessfully Created '" + count + "' Records In The Database!\n");
			}
			tr.commit();
			logger.info("\nSuccessfully Created '" + count + "' Records In The Database!\n");
		}
		catch(Exception sqlException) {
			if(null != session.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} 
		finally {
			if(session != null) {
				session.close();
			}

		}

	}//End of createData


	public static void displayData()
	{
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		Session session = sFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<Student> studList=new ArrayList<Student>();
		try{
			studList=session.createQuery("FROM Student").list();
			if(studList != null & studList.size() > 0) {
				for(Student studentObj : studList) {
					logger.info(studentObj.toString());
				}
			}
		}
		catch(Exception sqlException) {
			if(null != session.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} 
		finally {
			if(session != null) {
				session.close();
			}
		}
	}//End of displayData


	public static void updateData(int id)
	{
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		Session session = sFactory.openSession();
		Transaction tr = session.beginTransaction();

		try{
			Student stud=(Student)session.get(Student.class, id);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter Name of Student");
			String newName=sc.next();
			stud.setStudName(newName);
			System.out.println("Enter Name of Degree");
			String newDegree=sc.next();
			stud.setStudDegree(newDegree);
			session.save(stud);
			tr.commit();
		}
		catch(Exception sqlException) {
			if(null != session.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} 
		finally {
			if(session != null) {
				session.close();
			}
		}
	}// End of updateData


	public static void deleteData(int id)
	{
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		Session session = sFactory.openSession();
		Transaction tr = session.beginTransaction();

		try{
			Student stud=(Student)session.get(Student.class, id);
			session.delete(stud);
			tr.commit();
		}
		catch(Exception sqlException) {
			if(null != session.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} 
		finally {
			if(session != null) {
				session.close();
			}
		}
	}// End of deleteData

	public static void deleteAllData()
	{
		SessionFactory sFactory = HibernateUtils.getSessionFactory();
		Session session = sFactory.openSession();
		Transaction tr = session.beginTransaction();
		try{
			Query queryObj = session.createQuery("DELETE FROM Student");
			queryObj.executeUpdate();
			tr.commit();
		}
		catch(Exception sqlException) {
			if(null != session.getTransaction()) {
				logger.info("\n.......Transaction Is Being Rolled Back.......\n");
				session.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} 
		finally {
			if(session != null) {
				session.close();
			}
		}
	}//End of deleteAllData



}//End of Class




