package model.entities;

import model.student.Student;

public class Validate {
	private Validate() {}
	
	public static void student(Student student) throws IllegalArgumentException, EmptyString {
		if (student == null)
			throw new IllegalArgumentException("Student is null");
		if (student.name == null || student.name.trim().isEmpty()) 
			throw new EmptyString("Name");
		if (student.grade < 0 || student.grade > 10)
			throw new OutboundIntervalNumber("Grade");
		
	}
}
