package fileReaderAutomated;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		
		// Forma automatico de leitura de arquivo sem precisar fazer manualmente.
		// Forma: try with resources
		String path = "src\\fileReaderAutomated\\in.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine(); // ler a primeira linha
			
			while (line != null) {
				System.out.println(line); // mostrar a linha
				line = br.readLine(); // ler a linha
			}
			
		} catch (IOException e) { 
			System.err.println("Erro: " + e.getMessage());
		}
	
	}
}
