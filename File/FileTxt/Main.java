package readFile;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
		
		Scanner input = null;
		File file = new File("src\\readFile\\in.txt"); // Caminho do arquivo
		
		try {
		input = new Scanner(file);
		
			while(input.hasNextLine() == true) {
				System.out.println(input.nextLine()); // imprimir linha do arquivo
			}
		
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());;	
		
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
}
