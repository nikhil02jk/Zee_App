package com.zee.zee5_app.dto;

import java.math.BigDecimal;

import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Register implements Comparable<Register> {
	
	public Register(String id, String firstName, String lastName, String email, String password, BigDecimal contactNumber)
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		super();
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setPassword(password);
		this.contactNumber = contactNumber;
	}

	@Setter(value = AccessLevel.NONE)
	private String id;
	@Setter(value = AccessLevel.NONE)
	private String firstName;
	@Setter(value = AccessLevel.NONE)
	private String lastName;
	@Setter(value = AccessLevel.NONE)
	private String email;
	@Setter(value = AccessLevel.NONE)
	private String password;
	private BigDecimal contactNumber;
	
	public void setId(String id) throws InvalidIdLengthException {
		if(id.length()<6)
			throw new InvalidIdLengthException("id length is less than 6");
		this.id = id;
	}
	
	public void setFirstName(String firstName) throws InvalidNameException {
		if(firstName==null || firstName=="" || firstName.length()<2)
			throw new InvalidNameException("firstName is not valid");
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) throws InvalidNameException {
		if(lastName==null || lastName=="" || lastName.length()<2)
			throw new InvalidNameException("lastName is not valid");
		this.lastName = lastName;
	}
	
	public void setEmail(String email) throws InvalidEmailException {
		if(email==null || email=="" || email.length()<2 || !email.contains("@"))
			throw new InvalidEmailException("email is not valid");
		this.email = email;
	}
	
	public void setPassword(String password) throws InvalidPasswordException {
		if(password==null || password=="" || password.length()<2 || !password.matches("[A-Z a-z 0-9]+"))
			throw new InvalidPasswordException("password is not valid");
		this.password = password;
	}

	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return o.id.compareTo(this.getId());
	}

}
