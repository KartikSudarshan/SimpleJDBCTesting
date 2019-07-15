package myJDBCapp;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.learning.maven.jdbc.app.Customer;
import com.learning.maven.jdbc.app.CustomerDAO;
import com.learning.maven.jdbc.app.DatabaseConnectionManager;

class JDBCExecutorTest {
	DatabaseConnectionManager dcm;
	FileReader propertiesReader;
	Properties dbproperties;
	Connection connection;
	 CustomerDAO customerDAO;

	
	
	@BeforeAll
	public  void checkJDBCConnection() throws IOException {
		propertiesReader=new FileReader("src"+File.separator+"main"+File.separator+"resources"+File.separator+"db.properties");;
		dbproperties=new Properties();
		dbproperties.load(propertiesReader);
		final String host=System.getProperty("database.host", dbproperties.getProperty("database.host"));
		final String databasename=System.getProperty("postgres.database.name", dbproperties.getProperty("postgres.database.name")); 
		final String username=System.getProperty("postgres.database.username", dbproperties.getProperty("postgres.database.username")); 
		final String password=System.getProperty("postgres.database.password", dbproperties.getProperty("postgres.database.password"));
		dcm = new DatabaseConnectionManager(host, databasename, username, password);
		System.out.println(dcm.toString());
		try {
			 connection =dcm.getConnection();
			 customerDAO = new CustomerDAO(connection);
						 
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	void createAndDeleteJohnMarston() {
		
		try {
			connection =dcm.getConnection();
			 customerDAO = new CustomerDAO(connection);
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
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	
	
}
