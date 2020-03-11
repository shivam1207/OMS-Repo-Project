package com.example.DAO;


import java.util.List;

import com.example.DTO.Customer;

public interface CustomerDAO
{
	public void createTable();
	public void insertRow(String custName);
	public void updateNameWhere(String custName, Integer custID);
	public void deleteWhere(Integer id);
	public List<Customer> listCustomers();
}

