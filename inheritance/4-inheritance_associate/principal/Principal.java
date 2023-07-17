package principal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import entities.Employee;
import entities.HourlyPaidEmployee;
import entities.SalariedEmployee;

public class Principal {
	public static void main(String [] args) {

		try {
		Employee objeto1 = new SalariedEmployee(0, "Carla", 12000.00); // Objetivo: passar de uma subclasse para outra para mudar o tipo de contrato de trabalho.
		System.out.println(objeto1);
				
														// Como fazer: criando novo objeto, mas ambos tendo o mesma declaração do pai. 
		HourlyPaidEmployee objeto2 = new HourlyPaidEmployee(objeto1.getEmployeeID(), objeto1.getName(), 272.7273, 44); 
		System.out.println("Objeto copiado para outra subclasse: " + objeto2);
		
		List<Employee> lista1 = new ArrayList<>(); // Objetivo: passar de ArrayList para LinkedLis.
		lista1.add(objeto1);
		lista1.add(objeto2);
		System.out.println("\nArrayList: "+ lista1);
		
		lista1 = new LinkedList<>(lista1); // Como fazer: instanciando novamente, mas mudando para LinkedList. Ele mantém os objetos (não zera a lista).
		
		System.out.println("Convertido para LinkedList: " + lista1);
		
		// --------------------
		// funcionário Por hora
		HourlyPaidEmployee aline = new HourlyPaidEmployee(1, "Aline", 14.00, 120); // int employeeID, String name, double hourlyRate, int hoursWorked
		
		// funcionário Salário fixo
		SalariedEmployee luan = new SalariedEmployee(2, "Luan", 10000.00); // int employeeID, String name, double monthlySalary
		
		System.out.println("\nFuncionario por hora - Aline: " + aline);
		System.out.println("Funcionario fixo - Luan: " + luan);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
