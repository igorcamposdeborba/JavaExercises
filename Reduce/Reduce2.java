import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import entities.Student;


public class Reduce2 {
	public static void main(String[] args) {
		
		
		Student a1 = new Student("Igor", 10.0);
		Student a2 = new Student("Ana", 7.8);
		Student a3 = new Student("Bia", 3.5);
		Student a4 = new Student("Carla", 0.4);
		Student a5 = new Student("Pedro", 6.0);
		Student a6 = new Student("Anthony", 4.2);
		
		List<Student> student = Arrays.asList(a1, a2, a3, a4, a5, a6);
		
		Predicate<Student> approved = i -> i.getGrade() >= 7;
		Function<Student, Double> onlyGrade = i -> i.getGrade();
		BinaryOperator<Double> sum = (a, b) -> a + b;
		
		student.parallelStream() // parallelStream é uma build stream que constroi a operação. Ela executa de modo paralelo (não é bom para programação concorrente)
				.filter(approved) // operação intermediária
				.map(onlyGrade) // operação intermediária
				.reduce(sum) // operação de resultado
				.ifPresent(System.out::println);
		
		
	}
}
