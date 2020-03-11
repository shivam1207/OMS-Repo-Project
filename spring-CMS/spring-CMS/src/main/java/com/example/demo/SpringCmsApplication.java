package com.example.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.DAO.CustomerDAOImplementation;
import com.example.DAO.EmployeeDAOImplementation;
import com.example.DTO.Customer;
import com.example.DTO.Employee;

@SpringBootApplication
public class SpringCmsApplication 
{

	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		
		ApplicationContext ctx=SpringApplication.run(AppConfig.class);
		
		EmployeeDAOImplementation objEmployee=(EmployeeDAOImplementation) ctx.getBean(EmployeeDAOImplementation.class);
		objEmployee.createTable();
		System.out.println("TABLE CREATED/////");
		
		CustomerDAOImplementation objCustomer=(CustomerDAOImplementation) ctx.getBean(CustomerDAOImplementation.class);
		objCustomer.createTable();
		System.out.println("TABLE CREATED/////");
		
		
		/*Invoice objInvoice=(Invoice) ctx.getBean(InvoiceImpl.class);
		objInvoice.createTable();*/
		
		while(true)
		{
			System.out.println("\n------------------------------------");
			System.out.println("01. Add Employee");
			System.out.println("02. Update Employee");
			System.out.println("03. Delete Employee");
			System.out.println("04. List Employees");
			
			System.out.println("05. Add Customer");
			System.out.println("06. Update Customer");
			System.out.println("07. Delete Customer");
			System.out.println("08. List Customers");
			
			/*System.out.println("09. Add Invoice Details");
			System.out.println("10. Update Invoice");
			System.out.println("11. Delete Invoice");
			System.out.println("12. List Invoices");
			System.out.println("13. Exit");*/
			int option=scanner.nextInt();
			
			if(option==13) break;
			
			switch(option)
			{
			case 1:
				addEmployee(objEmployee, scanner);
				break;	
			case 2:
				updateEmployee(objEmployee, scanner);
				break;
			case 3:
				deleteEmployee(objEmployee, scanner);
				break;
			case 4:
				listEmployees(objEmployee);
				break;
				
			
			case 5:
				addCustomer(objCustomer, scanner);
				break;
			case 6:
				updateCustomer(objCustomer, scanner);
				break;
			case 7:
				deleteCustomer(objCustomer, scanner);
				break;
			case 8:
				listCustomers(objCustomer);
				break;
			
			
			/*case 9:
				addInvoice(objInvoice, scanner);
				break;
			case 10:
				updateInvoice(objInvoice, scanner);
				break;
			case 11:
				deleteInvoice(objInvoice, scanner);
				break;
			case 12:
				listInvoices(objInvoice);
				break;*/
				
			}
		}	
		
	}
	
	
	
	
	/*public static void main(String[] args) 
	{
		ApplicationContext context = SpringApplication.run(AppConfig.class);
		
		//CustomerDAOImplementation customerJdbcTemplate = context.getBean(CustomerDAOImplementation.class);
		
		EmployeeDAOImplementation employeeJdbcTemplate = context.getBean(EmployeeDAOImplementation.class);
		
		//runCustomerCRUD(customerJdbcTemplate);
		
		runEmployeeCRUD(employeeJdbcTemplate);
	}*/

	/*private static void runEmployeeCRUD(EmployeeDAOImplementation employeeJdbcTemplate) 
	{
		employeeJdbcTemplate.createDB();
		
		System.out.println("------------------------RECORDS INSERTION-----------------------");
		employeeJdbcTemplate.insert("Bablu", 21);
		employeeJdbcTemplate.insert("Parag", 22);
		
		System.out.println("----------------------LISTING MULTIPLE RECORDS");
		List<Employee> employeesLists = employeeJdbcTemplate.listEmployees();
		for(Employee record : employeesLists)
		{
			System.out.println("ID :- "+record.getId());
			System.out.println("NAME :- "+record.getName());
			System.out.println("AGE :- "+record.getAge());
		}
	
	}

	private static void runCustomerCRUD(CustomerDAOImplementation customerJdbcTemplate) 
	{
		customerJdbcTemplate.createDB();
		
		System.out.println("------------------------RECORDS INSERTION-----------------------");
		customerJdbcTemplate.insertData("Bablu", "Gorakhpur, UP");
		customerJdbcTemplate.insertData("Parag", "Morena, MP");
		
		System.out.println("----------------------LISTING MULTIPLE RECORDS");
		List<Customer> customersLists = customerJdbcTemplate.listCustomers();
		for(Customer record : customersLists)
		{
			System.out.println("ID :- "+record.getId());
			System.out.println("NAME :- "+record.getName());
			System.out.println("ADDRESS :- "+record.getAddress());
		}
	}*/

	/*private static void listInvoices(Invoice objInvoice)
	{
		List<InvoicePojo> objList=objInvoice.listInvoice();
		
		Iterator<InvoicePojo> itr=objList.iterator();
		
		while(itr.hasNext())
		{
			InvoicePojo objPojo=itr.next();
			System.out.println(objPojo.getBuyerID());
			System.out.println(objPojo.getSellerID());
		}
		
		
	}

	private static void deleteInvoice(Invoice objInvoice, Scanner scanner)
	{
		System.out.println("Enter Buyer ID");
		int buyerID=scanner.nextInt();
		
		objInvoice.deleteWhere(buyerID);
		
		System.out.println("Deleted Successfully");
		
	}

	private static void updateInvoice(Invoice objInvoice, Scanner scanner) 
	{
		System.out.println("Enter buyerID");
		int buyerID=scanner.nextInt();
		
		System.out.println("Enter New sellerID");
		int sellerID=scanner.nextInt();
		
		objInvoice.updateSellerIDWhere(sellerID, buyerID);
		
		System.out.println("Updated Successfully");
		
	}*/

	private static void listCustomers(CustomerDAOImplementation objCustomer)
	{
		List<Customer> objList=objCustomer.listCustomers();
		
		Iterator<Customer> itr=objList.iterator();
		
		while(itr.hasNext())
		{
			Customer objPojo=itr.next();
			System.out.println(objPojo.getId());
			System.out.println(objPojo.getName());
		}
		
		
	}

	private static void deleteCustomer(CustomerDAOImplementation objCustomer, Scanner scanner)
	{
		System.out.println("Enter customerID");
		int custID=scanner.nextInt();
		
		objCustomer.deleteWhere(custID);
		
		System.out.println("Deleted Successfully");
		
	}

	private static void updateCustomer(CustomerDAOImplementation objCustomer, Scanner scanner)
	{
		System.out.println("Enter customerID");
		int custID=scanner.nextInt();
		
		System.out.println("Enter New name");
		String custName=scanner.next();
		
		objCustomer.updateNameWhere(custName,custID);
		
		System.out.println("Updated Successfully");
		
	}

	private static void listEmployees(EmployeeDAOImplementation objEmployee)
	{
		List<Employee> objList=objEmployee.listEmployees();
		
		Iterator<Employee> itr=objList.iterator();
		
		while(itr.hasNext())
		{
			Employee objPojo=itr.next();
			System.out.println(objPojo.getId());
			System.out.println(objPojo.getName());
		}
		
	}

	private static void deleteEmployee(EmployeeDAOImplementation objEmployee, Scanner scanner)
	{
		System.out.println("Enter employeeID");
		int empID=scanner.nextInt();
		
		objEmployee.deleteWhere(empID);
		
		System.out.println("Deleted Successfully");
		
	}

	private static void updateEmployee(EmployeeDAOImplementation objEmployee, Scanner scanner)
	{
		System.out.println("Enter employeeID");
		int empID=scanner.nextInt();
		
		System.out.println("Enter New name");
		String empName=scanner.next();
		
		objEmployee.updateNameWhere(empName,empID);
		
		System.out.println("Updated Successfully");
		
	}

	public static void addEmployee(EmployeeDAOImplementation objEmployee, Scanner scanner)
	{
		/*System.out.println("Enter Employee ID:");
		int empID=scanner.nextInt();*/
		
		System.out.println("Enter Employee Name:");
		String empName=scanner.next();
		
		objEmployee.insertRow(empName);
		
		System.out.println("Added Succesfully");
	}
	
	public static void addCustomer(CustomerDAOImplementation objCustomer, Scanner scanner)
	{
		/*System.out.println("Enter Customer ID:");
		int custID=scanner.nextInt();*/
		
		System.out.println("Enter Employee Name:");
		String custName=scanner.next();
		
		objCustomer.insertRow(custName);
		
		System.out.println("Added Succesfully");
	}
	
	/*public static void addInvoice(Invoice objInvoice, Scanner scanner)
	{
		System.out.println("Enter Buyer ID:");
		int buyerID=scanner.nextInt();
		
		System.out.println("Enter Seller ID:");
		int sellerID=scanner.nextInt();
		
		objInvoice.insertRow(buyerID, sellerID);
		
		System.out.println("Added Succesfully");
	}*/
	
	
	
}
