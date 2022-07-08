package application;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import model.Student;

public class Program {
	public static void main (String [] args) {
		
		Student a1 = new Student("Igor", 10.0);
		Student a2 = new Student("Ana", 7.8);
		Student a3 = new Student("Bia", 3.5);
		Student a4 = new Student("Carla", 0.4);
		Student a5 = new Student("Pedro", 6.0);
		Student a6 = new Student("Anthony", 4.2);
		
		List <Student> students = Arrays.asList(a1, a2, a3, a4, a5, a6);
		
		
		Predicate <Student> approved = i -> i.getGrade() >= 6.0;
		
		Function <Student, String> congratsApproved = i -> "Congratulations " + i.getName() + "! You were approved with grade " + i.getGrade();
		
		// Filter approved students
		students.stream()
				.filter(approved)
				.map(congratsApproved)
				.forEach(System.out::println);
	}
}
