package com.example.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.DTO.Customer;

public class CustomerMapper implements RowMapper<Customer>
{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Customer objCustomer = new Customer();
		objCustomer.setId(rs.getInt("ID"));
		objCustomer.setName(rs.getString("NAME"));
		objCustomer.setAddress(rs.getString("ADDRESS"));
		return objCustomer;
	}

}