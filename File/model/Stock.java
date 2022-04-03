package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Stock {
	private Product [] product; // composição da classe Product para guardar num array os produtos
	private BufferedReader br;
	
	public Stock(String fileName) {
		fillStock(fileName);
	}
	
	public Product [] getProduct() {
		return product;
	}
	
	public void fillStock(String fileName) {
		try {
			// abrir arquivo para leitura
			FileReader fr = new FileReader(fileName); // Ler arquivo
			br = new BufferedReader(fr);// Ler conteúdo do arquivo

			int productQuantity = 0;
			String line = br.readLine(); // ignorar primeira linha do arquivo porque é o cabeçalho
			while (line != null) {
				productQuantity++;
				line = br.readLine();
			}
			System.out.println("Quantidade de produtos: " + productQuantity);
			
			br.close(); // fechar fluxo de conteúdo do bufferedReader

			product = new Product[productQuantity -1]; // instanciar array
			System.out.println("Quantidade de produtos no arquivo " + product.length);
			
			
			// abrir arquivo para leitura e preencher estoque
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			
			br.readLine(); // ignorar primeira linha do cabeçalho
			for (int i=0; i < product.length; i++) {
				line = br.readLine();
				String [] splitted = line.split("\\,");
				
				String typeProduct = splitted[3];
				String description = splitted[1];
				double price = Double.parseDouble(splitted[2]);
				
				
				if (splitted[0].equalsIgnoreCase("Alimento")) {
					String expirationDate = splitted[4];
					product[i] = new Food(typeProduct, description, price, expirationDate);
				
				} else if (splitted[0].equalsIgnoreCase("Vestuario")) {
					int stockQuantity = Integer.parseInt(splitted[4]);
					product[i] = new Clothing(typeProduct, description, price, stockQuantity);
				
				} else if (splitted[0].equalsIgnoreCase("Eletrodomestico")) {
					double ipi = Double.parseDouble(splitted[4]);
					product[i] = new HomeAppliance(typeProduct, description, price, ipi);
				}
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printStock() throws IllegalArgumentException {
		if (product == null) {
			throw new IllegalArgumentException();
		}
		
		for (Product p : product) {
			System.out.println(p); // mostrar em tela cada produto
		}
	}
}