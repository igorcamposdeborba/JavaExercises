import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import entities.Student;

public class Match {
	public static void main (String [] args) {
		Student a1 = new Student("Ana", 7.1);
		Student a2 = new Student("Luna", 6.1);
		Student a3 = new Student("Gui", 8.1);
		Student a4 = new Student("Gabi", 10.0);
		
		List<Student> students = Arrays.asList(a1, a2, a3, a4);
		
		Predicate<Student> approved = i -> i.getGrade() >= 7;
		
		System.out.println(students.stream().allMatch(approved)); // match todos (encontrar se todos foram aprovados)
		
		System.out.println(students.stream().anyMatch(approved)); // match algum
		
		System.out.println(students.stream().noneMatch(approved.negate())); // nenhum
		
	}
}
