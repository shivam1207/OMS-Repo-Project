package com.example.demo;

import javax.sql.DataSource;

import org.h2.server.web.WebServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.config.CustomerConfig;
import com.example.config.EmployeeConfig;

@EnableAutoConfiguration
@Configuration
@Import({EmployeeConfig.class, CustomerConfig.class})
public class AppConfig 
{
	/*@Bean
	ServletRegistrationBean h2ServeletBean() 
	{
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}*/
	
	@Bean
	public DataSource mysqlDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
}
