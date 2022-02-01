package com.zee.zee5_app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class IdNotFoundException extends Exception {

	public IdNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
