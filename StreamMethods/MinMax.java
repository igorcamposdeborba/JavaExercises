import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import entities.Student;

public class MinMax {
	public static void main (String [] args) {
		Student a1 = new Student("Ana", 7.1);
		Student a2 = new Student("Luna", 6.1);
		Student a3 = new Student("Gui", 8.1);
		Student a4 = new Student("Gabi", 10.0);
		
		List<Student> students = Arrays.asList(a1, a2, a3, a4);
		
		Comparator<Student> bestGrade = (student1, student2) -> {
			if (student1.getGrade() > student2.getGrade()) return 1;
			if (student1.getGrade() < student2.getGrade()) return -1;
			return 0;
		};
		
		System.out.println(students.stream().max(bestGrade).get());
		System.out.println(students.stream().min(bestGrade).get());
	}
}
