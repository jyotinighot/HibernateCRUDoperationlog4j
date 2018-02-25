package com.demo.hibernatecrudoperations;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.varia.NullAppender;

public class MainApp {
	public final static Logger logger = Logger.getLogger(MainApp.class);
	public static void main(String[] args) {
		org.apache.log4j.BasicConfigurator.configure(new NullAppender());
		List<Student> studList;int id;
		Scanner sc=new Scanner(System.in);
		logger.info(".......Hibernate Crud Operations Example.......\n");
		logger.info("\n=======CREATE RECORDS=======\n");
		DatabseOperations.createData();
		logger.info("\n=======READ RECORDS=======\n");
		DatabseOperations.displayData();
		logger.info("\n=======UPDATE RECORDS=======\n");
		System.out.println("EnterStudent ID of the Record to Update ");
		id=sc.nextInt();
		DatabseOperations.updateData(id);
		logger.info("\n=======READ RECORDS AFTER UPDATION=======\n");
		DatabseOperations.displayData();
		logger.info("\n=======DELETE RECORDS=======\n");
		System.out.println("EnterStudent ID of the Record to Delete ");
		id=sc.nextInt();
		DatabseOperations.deleteData(id);
		logger.info("\n=======READ RECORDS AFTER DELETION=======\n");
		DatabseOperations.displayData();
		logger.info("\n=======DELETE ALL RECORDS=======\n");
		logger.info("\nDelete All Records????? 1 for YES 0 for NO");
		if(sc.nextInt()==1){
			DatabseOperations.deleteAllData();
			logger.info("\n ALL Records Are Deleted from Database Table!\n");
		}
			
		
		System.exit(0);
	}//End of Main
}//End of Class
