package com.regapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement stmnt;
	@Override
	public void connectDB() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_2","root","Aman@1998");
		   stmnt = con.createStatement();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyCredential(String email, String password) {
		// TODO Auto-generated method stub
		try {
			ResultSet result = stmnt.executeQuery("select * from logi_emp where email='"+email+"' and password='"+password+"'");
		return result.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		return false;
	}

	@Override
	public void verifyCredential(String name, String email, String phone, String city) {
		// TODO Auto-generated method stub
		try {
			stmnt.executeUpdate("insert into employee values ('"+name+"','"+email+"','"+phone+"','"+city+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet readRegistration() {
		// TODO Auto-generated method stub
		
		try {
			ResultSet result= stmnt.executeQuery("select * from employee");
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteRegistration(String email) {
		// TODO Auto-generated method stub
		
		try {
			stmnt.executeUpdate("DELETE FROM employee WHERE email = '"+email+"'");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateRegistration(String email, String phone) {
		// TODO Auto-generated method stub
		
		
		try {
			stmnt.executeUpdate("update employee set phone='"+phone+"' where email='"+email+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
