package entitites;
import java.lang.Comparable;

public class Employee implements Comparable<Employee> {
	private String name;
	private Double salary;
	
	public Employee (String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName () {
		return name;
	}
	public Double getSalary () {
		return salary;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	public void setSalary (Double salary) {
		this.salary = salary;
	}
	
	// compareTo compara atributos de dois objetos. Ex.: comparar salário
	//compareTo retorna um número aleatório positivo, negativo ou zero, se o objeto atual é maior, menor ou igual ao comparado com base no atributo
	@Override
	public int compareTo (Employee otherObject) {
		return -salary.compareTo(otherObject.getSalary()); // o sinal de menos - mostra o salário do maior para o menor
	} 
}
