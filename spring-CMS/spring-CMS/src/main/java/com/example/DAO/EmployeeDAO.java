package com.example.DAO;

import java.util.List;

import com.example.DTO.Employee;

public interface EmployeeDAO
{
	public void createTable();
	public void insertRow(String empName);
	public void updateNameWhere(String empName, Integer empID);
	public void deleteWhere(Integer id);
	public List<Employee> listEmployees();
}
