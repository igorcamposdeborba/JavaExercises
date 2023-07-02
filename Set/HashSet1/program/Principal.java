package program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.User;

public class Principal {
	
	public static void main (String [] args) {

		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o caminho do arquivo");
		String path = input.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) { // HashSet não aceita repetições e fica fora de ordem. Útil para contar o numero de usuarios que acessaram o site
			
			Set<User> set = new HashSet<User>();
			
			String line = br.readLine(); // ler linha do arquivo
			while(line != null) {
				String [] fields = line.split(" "); // split para colocar num array cada atributo da linha
				String userName = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				
				set.add(new User(userName, moment)); // inserir no hashSet os valores sem duplicação e sem ordem
				
				line = br.readLine(); // ler linha do arquivo
			}
			System.out.println("Total de usuarios: " + set.size());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
}
