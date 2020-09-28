package com.employee.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.employee.dao.EmployeeDAO;
import com.employee1.Employee;

 public class Controller {
	public static Connection con=null;
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		int num;
		try {
		Class.forName("com.mysql.jdbc.Driver");

		//driverconnection
		
		   con = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/test","root","Kishore1142..");
		if(con!=null)
		{
			System.out.println("Connected");
		}
		Employee emp= new Employee();
		Scanner sc=new Scanner(System.in);
		    do {
				
				System.out.println("Enter your choice");
				System.out.println("Enter 1 if you want to insert data");
				System.out.println("Enter 2 if you want to select data");
				System.out.println("Enter 3 if you want to update data");
				System.out.println("Enter 4 if you want to delete data");
				System.out.println("Enter 0 to exit");
				num=sc.nextInt();
				
				switch(num) 
				{
				case 1:
					
					System.out.println("enter employee name");
					emp.setEmployeeName(sc.next());
	                System.out.println(emp.getEmployeeName());
	                
					System.out.println("enter employee address");
					emp.setEmployeeAddress(sc.next());
					
					System.out.println("enter employee Date of Birth");
					emp.setDateOfBirth(sc.next());
					
					System.out.println("enter employee experience");
					emp.setExperience(sc.nextInt());
					
					System.out.println("enter employee Date of Joining");
					emp.setDateOfJoining(sc.next());
				
					EmployeeDAO.insertion(emp);
					break;
				
				case 2:
					
					System.out.println("enter employee id");
					
					emp.setEmployeeId(sc.nextInt());
					System.out.println("Displaying Employee details");
					EmployeeDAO.display(emp);
					break;
					
				case 3:
					
					System.out.println("Enter Employee ID");
					emp.setEmployeeId(sc.nextInt());
					
					System.out.println("enter employee name");
					emp.setEmployeeName(sc.next());
					System.out.println("enter employee address");
					emp.setEmployeeAddress(sc.next());
					System.out.println("enter employee Date of Birth");
					emp.setDateOfBirth(sc.next());
					System.out.println("enter employee Date of Joining");
					emp.setDateOfJoining(sc.next());
					System.out.println("enter employee experience");
					emp.setExperience(sc.nextInt());
					EmployeeDAO.update(emp);
					break;
					
				case 4:	
					
					System.out.println("enter employee id");
					
					emp.setEmployeeId(sc.nextInt());
					System.out.println("Deleting Employee details");
					EmployeeDAO.delete(emp);
					break;
				
				}
				}while(num!=0);
		}
		catch (SQLException e) 
		{
		   e.printStackTrace();
	   	}
		catch (ClassNotFoundException c)
		{
		c.printStackTrace();
	    }
		
	}
	
}
