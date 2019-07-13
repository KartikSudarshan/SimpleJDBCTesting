package com.learning.maven.jdbc.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.Properties;


public class JDBCExecutor {

	public static void main(String[] args) throws IOException {
		
		FileReader propertiesReader=new FileReader("src"+File.separator+"main"+File.separator+"resources"+File.separator+"db.properties");;
		Properties dbproperties=new Properties();

		dbproperties.load(propertiesReader);
		System.out.println("Checking the connection to the Database");
		System.out.println("PropertiesFile is "+propertiesReader.toString());
		System.out.println("Hello Learing JDBC");
		
		final String host=System.getProperty("database.host", dbproperties.getProperty("database.host"));
		final String databasename=System.getProperty("postgres.database.name", dbproperties.getProperty("postgres.database.name")); 
		final String username=System.getProperty("postgres.database.username", dbproperties.getProperty("postgres.database.username")); 
		final String password=System.getProperty("postgres.database.password", dbproperties.getProperty("postgres.database.password"));
		
		DatabaseConnectionManager dcm = new DatabaseConnectionManager(host, databasename, username, password);
		System.out.println(dcm.toString());
		try {
			 Connection connection =dcm.getConnection();
			 CustomerDAO customerDAO = new CustomerDAO(connection);
			/* Creating Customer Values
			 * 
			 * Customer customer = new Customer(); customer.setFirstname("Arthur");
			 * customer.setLastname("Morgan");
			 * customer.setEmail("arthur.morgan@red.dead.redemption");
			 * customer.setPhone("(555) 555-1234"); customer.setAddress("1234 Main St");
			 * customer.setCity("Mount Vernon"); customer.setState("VA");
			 * customer.setZipcode("22121");
			 * customerDAO.create(customer);
			 */
			 
			/* Reading Customer Values
			 * 
			 * Customer customer =customerDAO.findById(197);
			 * System.out.println(customer.getFirstname()+" "+customer.getLastname());
			 */
			 
			 
			/* Updating Data 
			 * 
			 * Customer customer=customerDAO.findById(1000);
			 * System.out.println(customer.getFirstname()+" "+customer.getLastname()+" "
			 * +customer.getEmail());
			 * 
			 * customer.setEmail("adminisnotadmin@themachine.ww");
			 * customer=customerDAO.update(customer);
			 * System.out.println(customer.getFirstname()+" "+customer.getLastname()+" "
			 * +customer.getEmail());
			 */
			 
			  Customer customer = new Customer(); 
			  customer.setFirstname("John");
			  customer.setLastname("Marston");
			  customer.setEmail("john.marston@red.dead.redemption");
			  customer.setPhone("(555) 555-1234"); 
			  customer.setAddress("1234 Main St");
			  customer.setCity("Mount Vernon"); 
			  customer.setState("VA");
			  customer.setZipcode("22121");
			  Customer dbCustomer=customerDAO.create(customer);
			  System.out.println(dbCustomer);
			  customerDAO.delete(dbCustomer.getId());
			 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}