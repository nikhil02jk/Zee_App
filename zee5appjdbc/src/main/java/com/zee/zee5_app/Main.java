package com.zee.zee5_app;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.zee.zee5_app.dto.ROLE;
import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.service.UserService;
import com.zee.zee5_app.service.impl.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Register register = new Register("reg0006", "Eishika", "Chithreddy", "eishika@gmail.com", "eish123", null);
//			register.setContactNumber(new BigDecimal("9321654870"));
//			String result = service.addUser(register);
//			System.out.println(result);
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Optional<Register> register = service.getUserById("reg0001");
//			System.out.println(register.get());
//		} catch (IOException | IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			String result = service.deleteUserById("reg0006");
//			System.out.println(result);
//		} catch (IdNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Optional<List<Register>> optional = service.getAllUserDetails();
//			if(optional.isEmpty())
//				System.out.println("There is no records");
//			else
//				optional.get().forEach(e->System.out.println(e));
//			
//		} catch (IOException | InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		try {
//			UserService service = UserServiceImpl.getInstance();
//			Register register = new Register("reg0006", "Eishika2", "Chithreddy2", "eishika2@gmail.com", "eish2123", null);
//			register.setContactNumber(new BigDecimal("9321654872"));
//			String result = service.updateUser("reg0006", register);
//			System.out.println(result);
//		} catch (InvalidIdLengthException | InvalidNameException | InvalidEmailException | InvalidPasswordException | IOException | IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
