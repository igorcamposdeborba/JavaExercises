package fileWriterCreateFile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		
		// Forma: CRIA/RECRIA o arquivo sempre que instanciar new FileWriter(path);
		// Forma: ADICIONA ao final do arquivo sempre que instanciar new FileWriter(path, true); // com true no final
		String path = "src\\fileWriterCreateFile\\out.txt"; // arquivo de saída
				
		ArrayList <String> lines = new ArrayList<String>();
		lines.add("Good morning");
		lines.add("Good afternoon");
		lines.add("Good night");
		// String [] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){ // método automatico de instanciação: try with resources
			
			for (String i : lines) {
				bw.write(i); // escrever linha no arquivo. Ele não tem a quebra de linha. 
				bw.newLine(); // Obrigatório colocar bw.newLine();
			}
			System.out.println("Arquivo criado/sobrescrito");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
