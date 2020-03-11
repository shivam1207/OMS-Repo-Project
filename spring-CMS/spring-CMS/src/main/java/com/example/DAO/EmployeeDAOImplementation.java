package com.example.DAO;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.DTO.Employee;


@Repository
public class EmployeeDAOImplementation implements EmployeeDAO
{	
	@Autowired
	private JdbcTemplate objJdbcTemp;
	
	@Override
	public void createTable()
	{
		//objJdbcTemp.execute("DROP TABLE employee IF EXISTS");
		//objJdbcTemp.execute("CREATE TABLE employee(id INT, name VARCHAR(45)");
		objJdbcTemp.execute("CREATE TABLE employee" + "(" + "name VARCHAR(255), id SERIAL)");
	}

	@Override
	@Transactional
	public void insertRow(String empName)
	{
		String sql="INSERT INTO employee(name) VALUES(?)";
		objJdbcTemp.update(sql, empName);
	}

	@Override
	@Transactional
	public void updateNameWhere(String empName, Integer empID)
	{
		String sql="UPDATE employee SET name=? WHERE id=?";
		objJdbcTemp.update(sql, empName);
		
	}

	@Override
	@Transactional
	public void deleteWhere(Integer id)
	{
		String sql="DELETE FROM employee WHERE ID=?";
		objJdbcTemp.update(sql, id);
	}

	@Override
	public List<Employee> listEmployees()
	{
		String sql="SELECT * FROM employee";
		return objJdbcTemp.query(sql, new EmployeeMapper());
	}

}
