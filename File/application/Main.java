package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.Clothing;
import model.Food;
import model.Product;
import model.Stock;

public class Main {

	public static void main(String[] args) {
		Stock stock = new Stock("produtos.txt");		
		
		String saveProductIndex = ""; // Guardar a posição de cada produto
		
		Product [] product = stock.getProduct();
		
		// Alimento mais caro
		saveProductIndex += "Informações do alimento mais caro:\n";
		int indexFoodMostExpensive = -1;
		
		
		// Procurar o primeiro Alimento
		for (int i=0; i < product.length; i++) {
			if (product[i] instanceof Food) {
				indexFoodMostExpensive = i;
				break;
			}
		}
		
		// Procurar o Alimento mais caro que o primeiro encontrado
		if (indexFoodMostExpensive == -1) {
			saveProductIndex += "Não existem alimentos no estoque.\n";
		} else {
			for (int i = indexFoodMostExpensive + 1; i < product.length; i++) {
				if (product[i] instanceof Food) {
					if (product[i].getPrice() > product[indexFoodMostExpensive].getPrice()) { // comparar os preços do primeiro alimento com o segundo
						indexFoodMostExpensive = i;
					}
					saveProductIndex += product[indexFoodMostExpensive] + "\n"; // mostrar o primeiro mais caro se não caiu no if anterior
				}
			}
		}
		
		saveProductIndex += "Informações do eletrodoméstico mais barato:\n";
		int indexHomeApplianceMostExpensive = -1;
		
		// Procurar o primeiro eletrodoméstico
		for (int i=0; i < product.length; i++) {
			if (product[i] instanceof Clothing) {
				indexHomeApplianceMostExpensive = i;
				break;
			}
		}
		
		// Procurar o eletrodoméstico mais barato
		if (indexHomeApplianceMostExpensive == -1) {
			saveProductIndex += "Não existem Eletrodoméstico no estoque.\n";
		} else {
			for (int i = indexHomeApplianceMostExpensive + 1; i < product.length; i++) {
				if (product[i] instanceof Clothing) {
					if (product[i].getPrice() < product[indexHomeApplianceMostExpensive].getPrice()) {
						indexHomeApplianceMostExpensive = i;
					}
					saveProductIndex += product[indexHomeApplianceMostExpensive] + "\n";
				}
			}
		}
		
		
		saveProductIndex += "\nNome e quantidade em estoque de todos os produtos de vestuário:\n";
		// Procurar o nome e a quantidade no estoque do produto vestuário
		for (int i=0; i < product.length; i++) {
			if (product[i] instanceof Clothing) {
				saveProductIndex += product[i].getName() + " | Quantidade em estoque : " 
								    + ((Clothing) product[i]).getStockQuantity() + "\n"; // downcasting para acessar os métodos da subclasse vestuário
			}
		}
		
		// Criar arquivo com as informações acima.
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("info.txt"); // criar arquivo
			pw = new PrintWriter(fw); // escrever no conteúdo do arquivo
			
			pw.write(saveProductIndex);
		
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			pw.close(); // fechar buffer do conteúdo do arquivo
		} 
		
		
		
	}

}