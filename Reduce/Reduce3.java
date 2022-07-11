import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import entities.Average;
import entities.Student;

public class Reduce3 {
	public static void main (String [] args) {
		
		Student a1 = new Student("Ana", 7.1);
		Student a2 = new Student("Luna", 6.1);
		Student a3 = new Student("Gui", 8.1);
		Student a4 = new Student("Gabi", 10.0);
		
		List<Student> students = Arrays.asList(a1, a2, a3, a4);
		
		Predicate<Student> approved = i -> i.getGrade() >= 7;
		Function<Student, Double> soGrade = i -> i.getGrade();
		
		BiFunction<Average, Double, Average> calcAverage = (average, grade) -> average.add(grade);
				
		BinaryOperator<Average> combineAverage = (m1, m2) -> Average.blend(m1, m2);
				
		
		Average average = students.stream()
				.filter(approved)
				.map(soGrade)
				.reduce(new Average(), calcAverage, combineAverage);
		
		System.out.println("Media dos aprovados: " + average.getValue());
	}
}
