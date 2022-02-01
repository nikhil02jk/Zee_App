package com.zee.zee5_app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.zee.zee5_app.utils.PasswordUtils;

@Configuration
@ComponentScan("com.zee.zee5_app")
@PropertySource("classpath:application.properties")
public class Config {
	
	@Autowired
	Environment environment;
	
	@Bean(name="ds")  //
	@Scope("prototype")  // to create multiple instance, if we call getbean n times, we get n objects.
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		basicDataSource.setInitialSize(5);
//		try {
//			basicDataSource.getConnection().setAutoCommit(false);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		basicDataSource.setDefaultAutoCommit(false);
		
		return basicDataSource;
	}
	@Bean
	public PasswordUtils passwordUtils() {
	 return new PasswordUtils();
 }
}

