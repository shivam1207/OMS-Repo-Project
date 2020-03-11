package com.example.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.example.DTO.Employee;
	
public class EmployeeMapper implements RowMapper<Employee>
{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Employee objPojo = new Employee();
		objPojo.setName(rs.getString("name"));
		objPojo.setId(rs.getInt("id"));
	    return objPojo;
		
	}

}
