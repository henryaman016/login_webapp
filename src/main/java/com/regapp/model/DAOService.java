package com.regapp.model;

import java.sql.ResultSet;

public interface DAOService {

	public void connectDB();

	public boolean verifyCredential(String email, String password);

	public void verifyCredential(String name, String email, String phone, String city);

	public ResultSet readRegistration();

	public void deleteRegistration(String email);

	public void updateRegistration(String email, String phone);

	
}
