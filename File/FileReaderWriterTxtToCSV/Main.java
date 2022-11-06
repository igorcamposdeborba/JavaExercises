package fileReaderWriterTxtToCSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		
		String strPath = "";
		while (!strPath.contains(".txt")) {
			System.out.println("Digite o caminho do arquivo .txt");
			strPath = input.nextLine();
		}
		
		
		List <Product> fileList = new ArrayList<Product>(); // guardar arquivo temporariamente na memoria
		
		try (BufferedReader br = new BufferedReader(new FileReader(strPath))) {
			File pathFile = new File(strPath); // criar caminho do arquivo
			String sourceFolder = pathFile.getParent(); // caminho da pasta
			boolean success = new File(sourceFolder + "\\out").mkdir(); // criar subpasta
			String targetFileString = sourceFolder + "\\out\\summary.csv"; // criar arquivo .csv
			
			String line = br.readLine(); // ler linha
			
			while (line != null) {
				
				String [] fields = line.split(","); // colocar num array cada coluna
				String name = fields[0]; // inserir cada campo no array
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				Product product = new Product(name, price, quantity);// instanciar objeto linha do arquivo
				fileList.add(product); // adicionar linha no array
				
				line = br.readLine(); // ler linha até chegar numa linha null do fim do arquivo
			}
			
			// Escrever arquivo
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileString))) {
				
				for (Product i : fileList) {
					bw.write(i.getName() + "," + String.format("%.2f", i.totalPrice()));
					bw.newLine();
				}
				
				System.out.println(targetFileString + " criado");
				
			} catch (IOException e) {
				System.err.println("Erro durante escrita/criacao do arquivo: " + e.getMessage());;
			}
			
		} catch (IOException e) {
			System.err.println("Erro durante leitura do arquivo: " + e.getMessage());;
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			input.close();
		}
		
	}
}
