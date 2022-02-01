package com.zee.zee5_app;

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.zee.zee5_app.config.Config;
import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.repository.UserRepository;

public class MainSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		
		DataSource dataSource = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource.hashCode());
		DataSource dataSource2 = applicationContext.getBean("ds",DataSource.class);
		System.out.println(dataSource2.hashCode());
		System.out.println(dataSource.equals(dataSource2));  // it returns false ,coz it creates multiple instance.

//		try {
//			Register register = new Register("reg0099", "Nishanth", "JK", "nishanth@gmail.com", "nish123", null);
//			register.setContactNumber(new BigDecimal("9321654870"));
//			String result = userRepository.addUser(register);
//			System.out.println(result);
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		applicationContext.close();

	}

}
