package genericsAndFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*Uma empresa de consultoria deseja avaliar a performance de produtos,
	funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar
	o maior dentre um conjunto de elementos. Fazer um programa que leia um
	conjunto de produtos a partir de um arquivo, conforme exemplo, e depois
	mostre o mais caro deles.*/

public class Main {
	public static void main (String [] args) {
		
		List <Products> list = new ArrayList<>(); // array
		
		String path = "C:\\Exercicios\\NelioAlves\\Exercicios\\exercise\\generics\\src\\in.txt";
		
		// Try with resources on parameter
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { // // acessar arquivo e guardar numa stream de dados
			
			String line = br.readLine(); // pular primeira linha de cabeçalho do arquivo
			
			while (line != null) { // ler até o fim do arquivo
				String [] fields = line.split(";");
				list.add(new Products(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			
			Products prod = CalculationService.max(list); // eu uso o método max.
			// Já que CalculationService tem um método estático, não precisa instanciar porque é de classe (static) e não de objeto (instancição)
			System.out.println("Mais caro: " + prod);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
