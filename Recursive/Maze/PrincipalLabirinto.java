package application;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import model.Labirinto;

public class PrincipalLabirinto {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o nome do arquivo e a extensao. Exemplo: arquivo.txt");
		String file = input.nextLine();
		
		Labirinto labirinto = new Labirinto(file);
		
		String resultadoJogo = "";
		
		// verificar se há caminho válido
		try {
			if (labirinto.verificarCaminho(file) == true) { 
				resultadoJogo = "Existe um caminho para o labirinto"; 
				System.out.println("Existe um caminho para o labirinto");
			} else {
				resultadoJogo = "Nao existe um caminho para o labirinto";
				System.out.println("Nao existe um caminho para o labirinto");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		// criar arquivo
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("info.txt"); // criar arquivo
			pw = new PrintWriter(fw); // habilitar a escrita do conteúdo no arquivo
			
			pw.write(resultadoJogo); // escrever conteúdo no arquivos
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
		
	}
}
