package com.gmail.nelya;

public class ExcessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The group is full!";
	}

}