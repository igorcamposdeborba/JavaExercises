package manipulateFolders;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(new Locale("pt", "BR"));
	
		// Manipular pastas com a classe File
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o caminho de uma pasta: ");
		String strPath = input.nextLine();
		
		File path = new File(strPath);
		
		File [] folders = path.listFiles(File::isDirectory); // armazenar a lista de PASTAS
		
		System.out.println("Pastas");
		for (File i : folders) {
			System.out.println(i); // mostrar as pastas
		}
		
		File [] files = path.listFiles(File::isFile); // armazenar a lista de ARQUIVOS
		
		System.out.println("\nArquivos");
		for (File i : files) {
			System.out.println(i); // mostrar os arquivos
		}
		
		
		boolean success = new File(strPath + "\\subpastacriada").mkdir(); // CRIAR SUBPASTA
		System.out.println("Subpasta criada: " + success);
		
		
		input.close();
	}
}
