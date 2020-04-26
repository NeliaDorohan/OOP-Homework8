package com.gmail.nelya;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) {

		Student[] students = new Student[10];
		Group group1 = new Group(students, "FM-101");
		try {
			group1.addStudent(new Student("Maria", "Crit", "female", 17, "FM-101", 111));
			group1.addStudent(new Student("Maksym", "Lid", "male", 18, "FM-101", 112));
			group1.addStudent(new Student("Oleh", "Hor", "male", 17, "FM-101", 113));
			group1.addStudent(new Student("Viktor", "Smith", "male", 19, "FM-101", 114));
			group1.addStudent(new Student("Andriy", "Roy", "male", 18, "FM-101", 115));
			group1.addStudent(new Student("Mykhailo", "Huk", "male", 17, "FM-101", 116));
			group1.addStudent(new Student("Maksym", "Leaf", "male", 18, "FM-101", 117));
			group1.addStudent(new Student("Olha", "Fun", "female", 17, "FM-101", 118));
			group1.addStudent(new Student("Viktoria", "Sven", "female", 17, "FM-101", 119));
			group1.addStudent(new Student("Artem", "Rix", "male", 18, "FM-101", 120));
			// Add eleventh student
			group1.addStudent(new Student("Arsen", "Sor", "male", 18, "FM-101", 121));
		} catch (ExcessException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();

// findStudent and removeStudent methods
		System.out.println("You have found " + group1.findStudent("Smith"));
		System.out.println("You have removed the student - " + group1.removeStudent(116));

		System.out.println();

		group1.sortArray(students);
		for (Student st : students) {
			System.out.println(st);
		}

		System.out.println();

// getRecruterStudents method
		System.out.println("getRecruterStudents method");
		Student[] recruterStudents = group1.getRecruter();
		for (Student st : recruterStudents) {
			System.out.println(st);
		}

		System.out.println();

//		Writing into the file and reading from the file
		System.out.println("Inserting data");
		System.out.println();
		group1.printGroup();

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("file"))) {
			os.writeObject(group1);
		} catch (IOException e) {
			System.out.println("Error insert group");
		}
		System.out.println();
		Group group2 = null;
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("file"))) {
			group2 = (Group) is.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error read group");
		}
		System.out.println("Reading data");
		System.out.println();
		group2.printGroup();
	}

}
