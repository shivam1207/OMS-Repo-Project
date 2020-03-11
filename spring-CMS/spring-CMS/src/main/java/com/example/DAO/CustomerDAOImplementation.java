package com.example.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DTO.Customer;


@Repository
public class CustomerDAOImplementation implements CustomerDAO
{	
	@Autowired
	private JdbcTemplate objJdbcTemp;
	
	@Override
	public void createTable()
	{
		//objJdbcTemp.execute("DROP TABLE customer IF EXISTS");
		//objJdbcTemp.execute("CREATE TABLE customer(id INT, name VARCHAR(45)");
		objJdbcTemp.execute("CREATE TABLE customer" + "(" + "name VARCHAR(255), id SERIAL)");
	}

	@Override
	@Transactional
	public void insertRow(String custName)
	{
		String sql="INSERT INTO customer VALUES(?)";
		objJdbcTemp.update(sql, custName);
	}

	@Override
	@Transactional
	public void updateNameWhere(String custName, Integer custID)
	{
		String sql="UPDATE customer SET name=? WHERE id=?";
		objJdbcTemp.update(sql, custName);
		
	}

	@Override
	@Transactional
	public void deleteWhere(Integer id)
	{
		String sql="DELETE FROM customer WHERE ID=?";
		objJdbcTemp.update(sql, id);
	}

	@Override
	public List<Customer> listCustomers()
	{
		String sql="SELECT * FROM customer";
		return objJdbcTemp.query(sql, new CustomerMapper());
	}
		
}
