package com.zee.zee5_app.exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidAmountException extends Exception {

	public InvalidAmountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
