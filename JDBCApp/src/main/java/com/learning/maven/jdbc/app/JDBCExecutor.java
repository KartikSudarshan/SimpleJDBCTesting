package com.learning.maven.jdbc.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

	public static void main(String[] args) {
		System.out.println("Hello Learing JDBC");
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres",
				"mysecretpassword");
		try {
			Connection connection =dcm.getConnection();
			 CustomerDAO customerDAO = new CustomerDAO(connection);
	            Customer customer = new Customer();
	            customer.setFirstname("Arthur");
	            customer.setLastname("Morgan");
	            customer.setEmail("arthur.morgan@red.dead.redemption");
	            customer.setPhone("(555) 555-1234");
	            customer.setAddress("1234 Main St");
	            customer.setCity("Mount Vernon");
	            customer.setState("VA");
	            customer.setZipcode("22121");

	            customerDAO.create(customer);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
