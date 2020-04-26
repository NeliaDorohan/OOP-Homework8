package com.gmail.nelya;

import java.io.Serializable;
import java.util.Arrays;

public class Group implements Comisariat, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Student[] students = new Student[10];
	private String groupName;

	public Group(Student[] students, String groupName) {
		super();
		this.students = students;
		this.groupName = groupName;
	}

	public Group() {
		super();
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addStudent(Student st) throws ExcessException {
		if (st == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = st;
				st.setGroupName(this.groupName);
				System.out.println("You have added the student " + st + " in group " + st.getGroupName());
				return;
			}
		}
		throw new ExcessException();
	}

	public boolean removeStudent(int recNumber) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getRecNumber() == recNumber) {
				students[i] = null;
				return true;
			}
		}
		return false;
	}

	public Student findStudent(String lastName) {
		for (Student st : students) {
			if (st != null && lastName == st.getLastName()) {
				return st;
			}
		}
		return null;
	}

	public void printGroup() {
		for (Student st : students) {
			System.out.println(st);
		}
	}

	public void sortArray(Student[] students) {
		int sortedIndex = students.length;
		int numberOfSwap = 1;
		while (numberOfSwap > 0) {
			numberOfSwap = 0;
			for (int i = 0; i < sortedIndex - 1; i++) {
				if (compareStudent(students[i], students[i + 1]) > 0) {
					Student temp = students[i];
					students[i] = students[i + 1];
					students[i + 1] = temp;
					numberOfSwap += 1;
				}
			}
			sortedIndex -= 1;
		}
	}

	// Sorting method
	public static int compareStudent(Student a, Student b) {
		if (a != null && b == null) {
			return 1;
		}
		if (a == null && b != null) {
			return -1;
		}
		if (a == null && b == null) {
			return 0;
		}
		if (a.getFirstName().compareTo(b.getFirstName()) > 0) {
			return 1;
		}
		if (a.getFirstName().compareTo(b.getFirstName()) < 0) {
			return -1;
		}
		return 0;
	}

	@Override
	public Student[] getRecruter() {
		int n = 0;
		for (Student st : students) {
			if (st != null && st.getAge() >= 18 && st.getGender() == "male") {
				n += 1;
			}
		}
		Student[] recruterStudents = new Student[n];
		int i = 0;
		for (Student st : students) {
			if (st != null && st.getAge() >= 18 && st.getGender() == "male") {
				recruterStudents[i] = st;
				i = i + 1;
			}
		}
		return recruterStudents;
	}
	
	@Override
	public String toString() {
		return "[" + Arrays.toString(students) + ", groupName=" + groupName + "]";
	}
}
