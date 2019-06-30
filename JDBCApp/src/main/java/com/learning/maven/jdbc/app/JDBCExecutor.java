package com.learning.maven.jdbc.app;

import java.sql.Connection;

import java.sql.SQLException;


public class JDBCExecutor {

	public static void main(String[] args) {
		System.out.println("Hello Learing JDBC");
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres",
				"mysecretpassword");
		try {
			 Connection connection =dcm.getConnection();
			 CustomerDAO customerDAO = new CustomerDAO(connection);
			/* Creating Customer Values
			 * Customer customer = new Customer(); customer.setFirstname("Arthur");
			 * customer.setLastname("Morgan");
			 * customer.setEmail("arthur.morgan@red.dead.redemption");
			 * customer.setPhone("(555) 555-1234"); customer.setAddress("1234 Main St");
			 * customer.setCity("Mount Vernon"); customer.setState("VA");
			 * customer.setZipcode("22121");
			 * customerDAO.create(customer);
			 */
			 Customer customer =customerDAO.findById(197);
	          System.out.println(customer.getFirstname()+" "+customer.getLastname());
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
