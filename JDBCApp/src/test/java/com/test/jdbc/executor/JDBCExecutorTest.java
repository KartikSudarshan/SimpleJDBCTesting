package com.test.jdbc.executor;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learning.maven.jdbc.app.Customer;
import com.learning.maven.jdbc.app.CustomerDAO;
import com.learning.maven.jdbc.app.DatabaseConnectionManager;

public class JDBCExecutorTest {
	FileReader propertiesReader;

	Properties dbproperties;
	DatabaseConnectionManager dcm;
	Connection connection;
	CustomerDAO customerDAO;

	@BeforeClass
	public void beforeClass() throws IOException, SQLException {
		final String host = System.getProperty("database.host", "localhost");
		final String databasename = System.getProperty("postgres.database.name", "hplussport");
		final String username = System.getProperty("postgres.database.username", "postgres");
		final String password = System.getProperty("postgres.database.password", "mysecretpassword");

		dcm = new DatabaseConnectionManager(host, databasename, username, password);
		connection = dcm.getConnection();
		customerDAO = new CustomerDAO(connection);
		Assert.assertNotNull(connection, "unable to setup the connection");
		Assert.assertNotNull(customerDAO, "unable to get the Customer DAO");
	}

	@Test
	public void createAnEntryToDatabaseTest() {
		// Creating Customer Values

		Customer customer = new Customer();
		customer.setFirstname("Arthur");
		customer.setLastname("Morgan");
		customer.setEmail("arthur.morgan@red.dead.redemption");
		customer.setPhone("(555) 555-1234");
		customer.setAddress("1234 Main St");
		customer.setCity("Mount Vernon");
		customer.setState("VA");
		customer.setZipcode("22121");

		Customer result = customerDAO.create(customer);
		Assert.assertNotNull(result, "Something went wrong. Could not rertieve the Customer data");

	}

	@Test
	public void ReadEntriesFromDatabaseTest() {
		Customer customer = customerDAO.findById(197);
		Assert.assertNotNull(customer, "Something went wrong. Could not rertieve the Customer data");

		System.out.println(customer.getFirstname() + " " + customer.getLastname());
	}

	@Test
	public void UpdatingEntriesinTheDatabaseTest() {
		Customer customer = customerDAO.findById(1000);
		System.out.println(customer.getFirstname() + " " + customer.getLastname() + " " + customer.getEmail());

		customer.setEmail("adminisnotadmin@themachine.ww");
		customer = customerDAO.update(customer);
		Assert.assertNotNull(customer, "Something went wrong. Could not rertieve the Customer data");
		System.out.println(customer.getFirstname() + " " + customer.getLastname() + " " + customer.getEmail());
	}

	@Test
	public void DeletingEntriesFromTheDatabaseTest() {

		// Deleting an entry
		Customer customer = new Customer();
		customer.setFirstname("John");
		customer.setLastname("Marston");
		customer.setEmail("john.marston@red.dead.redemption");
		customer.setPhone("(555) 555-1234");
		customer.setAddress("1234 Main St");
		customer.setCity("Mount Vernon");
		customer.setState("VA");
		customer.setZipcode("22121");
		Customer dbCustomer = customerDAO.create(customer);
		Assert.assertNotNull(dbCustomer, "Something went wrong. Could not rertieve the Customer data");
		System.out.println(dbCustomer);
		customerDAO.delete(dbCustomer.getId());
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Generating the Report");
	}
}
