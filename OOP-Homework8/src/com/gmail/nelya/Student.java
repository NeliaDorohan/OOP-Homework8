package com.gmail.nelya;

import java.io.Serializable;

public class Student extends Human implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupName;
	private int recNumber;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String gender, int age, String groupName, int recNumber) {
		super(firstName, lastName, gender, age);
		this.groupName = groupName;
		this.recNumber = recNumber;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getRecNumber() {
		return recNumber;
	}

	public void setRecNumber(int recNumber) {
		this.recNumber = recNumber;
	}
	

	@Override
	public String toString() {
		return "Student [groupName=" + groupName + ", recNumber=" + recNumber + ", " + super.toString();
	}
}
