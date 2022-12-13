import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Associate;

public class Principal {
	public static void main(String [] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o caminho do arquivo");
		String path = input.nextLine();
		
		List <Associate> associateList = new ArrayList<Associate>();
		
		
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

			String line = bf.readLine();
			
			while (line != null) {
				
				// split each field to after instantiate array
				String [] fields = line.split(",");
				
				String name = fields[0];
				String email = fields[1];
				double salary = Double.parseDouble(fields[2]);
				
				associateList.add(new Associate(name, email, salary)); // instantiate associate and add in arrayList
				
				line = bf.readLine();
			}
			
			System.out.println("Digite o salario minimo do filtro");
			double salaryBase = input.nextDouble();
			
			List <String> emailList = associateList.stream()
										 		   .filter(e -> e.getSalary() > salaryBase)
												   .map(e -> e.getEmail())
												   .sorted()
												   .collect(Collectors.toList());
			
			System.out.println("E-mail das pessoas com salario maior que R$ " + String.format(".2f", emailList) + ": ");
			emailList.forEach(System.out::println);
			
			
			double salarySum = associateList.stream()
												 .filter(e -> e.getName().charAt(0) == 'M')
												 .map(e -> e.getSalary())
												 .reduce(0.0, (x, y) -> x + y);
												 
			System.out.println("Soma dos salarios das pessoas que tem o nome iniciando com a letra M: R$" + salarySum);
			
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			input.close();
		}
		
	}
}
