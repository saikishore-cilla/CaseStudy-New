package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.employee.controller.Controller;
import com.employee1.Employee;



public class EmployeeDAO {
	static Controller ob=new Controller();
	static Scanner sc=new Scanner(System.in);
	static String employeename, employeeadd, DateofBirth,DateofJoining;
	static int employeeid,experience,res,rowsInserted;;
	static Connection con;
	
	/* we use below code to insert data
	 * insert/create operation */
	
	public static int insertion(Employee emp) throws ClassNotFoundException, SQLException {
		
	
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		 con = DriverManager.getConnection
						("jdbc:mysql://localhost:3306/test","root","Kishore1142..");
	
			
			String query="INSERT INTO employeee (Employeename,Employeeaddress,dateofbirth,experience,dateofjoining) VALUES(?, ?, ?,?,?)";
		PreparedStatement statement=con.prepareStatement(query);
		statement.setString(1, emp.getEmployeeName());
		statement.setString(2, emp.getEmployeeAddress());
		statement.setString(3, emp.getDateOfBirth());
		statement.setInt(4, emp.getExperience());
		statement.setString(5, emp.getDateOfJoining());
	
		 rowsInserted=statement.executeUpdate();
		 if (rowsInserted >0)
		 {
		 System.out.println("data inserted");
		 }
		}
		
		catch (SQLException e) 
		{
			   e.printStackTrace();
		 }
		System.out.println(rowsInserted);
		
		
		return rowsInserted;
	}

	
	/* we use below code to display data
	 * display/read operation */
	
	public static void display(Employee emp) throws SQLException {
	
		
		String sql="SELECT * FROM employeee where EMPLOYEEID=?";
		PreparedStatement statement=ob.con.prepareStatement(sql);
		statement.setInt(1, emp.getEmployeeId());
	
		 ResultSet rs = statement.executeQuery();
		 while(rs.next()){
	   
			 //Retrieve by column name
	         
	         String employeename = rs.getString("EMPLOYEENAME");
	         String employeeadd = rs.getString("EMPLOYEEADDRESS");
	         String DateofBirth  = rs.getString("DATEOFBIRTH");
	         String DateofJoining  = rs.getString("DATEOFJOINING");
	         int experience = rs.getInt("EXPERIENCE");
	         int employeeid = rs.getInt("EMPLOYEEID");

	         //Display values
	         System.out.print("Name: " + employeename);
	         System.out.print(", Address: " + employeeadd);
	         System.out.print(", DateofBirth: " + DateofBirth);
	         System.out.println(", DateofJoining: " + DateofJoining);
	         System.out.println("Experience :"+experience);
	         System.out.println("EmployeeID :"+employeeid);
	      }
	      rs.close();
	}
	
	/* we use below code to update data
	 * update operation */	
	
	public static void update(Employee emp) throws SQLException {
		
		String tempq="SELECT * FROM employeee where EMPLOYEEID=?";
		PreparedStatement statement=ob.con.prepareStatement(tempq);
		statement.setInt(1, emp.getEmployeeId());
		ResultSet n=statement.executeQuery();
		boolean b=n.next();
		if(b==false)
		{
			System.out.println("Data not present");
		}
		else
		{
			
		String query="UPDATE employeee set EMPLOYEENAME=?,EMPLOYEEADDRESS=?,DATEOFBIRTH=?,EXPERIENCE=?,DATEOFJOINING=?  WHERE EMPLOYEEID=?";
		PreparedStatement statement1=ob.con.prepareStatement(query);
		statement1.setString(1, emp.getEmployeeName());
		statement1.setString(2, emp.getEmployeeAddress());
		statement1.setString(3, emp.getDateOfBirth());
		statement1.setInt(4, emp.getExperience());
		statement1.setString(5, emp.getDateOfJoining());
		statement1.setInt(6, emp.getEmployeeId());
		
		int rowsInserted=statement1.executeUpdate();
		if(rowsInserted>0)
		{
			System.out.println("Updated");
		}
		}
	}
	
	/* we use below code to delete data
	 * delete operation */
	
	public static void delete(Employee emp) throws SQLException {
		
		String sql="DELETE FROM employeee WHERE EMPLOYEEID=?";
		PreparedStatement statement=ob.con.prepareStatement(sql);
		statement.setInt(1, emp.getEmployeeId());
	int rowsDeleted=statement.executeUpdate();
	if(rowsDeleted>0)
	{
		System.out.println("Successfully deleted");
	}
	else
		System.out.println("Deletion unsuccessful");
		
	}
	
}
