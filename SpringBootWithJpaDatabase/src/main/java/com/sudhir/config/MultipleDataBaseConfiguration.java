package com.sudhir.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("application.properties")
public class MultipleDataBaseConfiguration {
	
	@Autowired
	Environment environment;
	
	// Considering Postgresql would be primary database
	@Primary
	@Bean(name = "postgresDataSource")
	public DataSource postgresDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.post.driverClass"));
		dataSource.setUrl(environment.getProperty("spring.post.url"));
		dataSource.setUsername(environment.getProperty("spring.post.username"));
		dataSource.setPassword(environment.getProperty("spring.post.password"));
		return dataSource;
	}
	
	// for mysql DataSource
	@Bean(name = "mysqlDataSource")
	public DataSource mysqlDataSource() {
		//return DataSourceBuilder.create().build();
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.mysql.driverClass"));
		dataSource.setUrl(environment.getProperty("spring.mysql.url"));
		dataSource.setUsername(environment.getProperty("spring.mysql.username"));
		dataSource.setPassword(environment.getProperty("spring.mysql.password"));
		return dataSource;
	}
}
