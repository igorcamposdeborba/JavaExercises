package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entitites.Employee;

public class Program {
	public static void main(String [] args) {
		
		List <Employee> listEmployee = new ArrayList<Employee>(); // dynamic list of employees
		
		String path = "C:\\Exercicios\\NelioAlves\\InterfaceComparableObjects\\in.csv";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			
			String employeeCsv = br.readLine(); // read first line
			
			while (employeeCsv != null) {
				String [] fields = employeeCsv.split(";"); // split by comma inner array
				listEmployee.add(new Employee(fields[0], Double.parseDouble(fields[1]))); // get attributes from line
				employeeCsv = br.readLine(); // read next line
			}
			
			// organize list
			Collections.sort(listEmployee);
			for (Employee emp : listEmployee) {
			System.out.println(emp.getName() + ", " + emp.getSalary());
			}
			
			
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
