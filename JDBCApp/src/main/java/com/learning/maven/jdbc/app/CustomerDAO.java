package com.learning.maven.jdbc.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.learning.maven.jdbc.app.util.DataAccessObject;

public class CustomerDAO extends DataAccessObject<Customer> {
	private static final String INSERT = "INSERT INTO customer (first_name, last_name,"
			+ "email, phone, address, city, state, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ONE = "SELECT customer_id, first_name, last_name , email, "
			+ "phone, address, city, state, zipcode FROM customer where customer_id=?";

	public CustomerDAO(Connection connection) {
		super(connection);
	}

	@Override
	public Customer findById(long id) {
		Customer customer =new Customer();
		try(PreparedStatement statement=this.connection.prepareStatement(GET_ONE);){
			statement.setLong(1, id);
			ResultSet resultset= statement.executeQuery();
			while (resultset.next()) {
				customer.setId(resultset.getLong("customer_id"));
				customer.setFirstname(resultset.getString("first_name"));
				customer.setLastname(resultset.getString("last_name"));
				customer.setEmail(resultset.getString("email"));
				customer.setPhone(resultset.getString("phone"));
				customer.setAddress(resultset.getString("address"));
				customer.setCity(resultset.getString("city"));
				customer.setState(resultset.getString("state"));
				customer.setZipcode(resultset.getString("zipcode"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		return null;
	}

	@Override
	public Customer update(Customer dto) {
		return null;
	}

	@Override
	public Customer create(Customer dto) {
		try (PreparedStatement statement = this.connection.prepareStatement(INSERT);) {
			statement.setString(1, dto.getFirstname());
			statement.setString(2, dto.getLastname());
			statement.setString(3, dto.getEmail());
			statement.setString(4, dto.getPhone());
			statement.setString(5, dto.getAddress());
			statement.setString(6, dto.getCity());
			statement.setString(7, dto.getState());
			statement.setString(8, dto.getZipcode());
			statement.execute();
			int id =this.getLastVal(CUSTOMER_SEQUENCE);
			return this.findById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(long id) {

	}

}
