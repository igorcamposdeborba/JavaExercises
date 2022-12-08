package mapAndFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*Na contagem de votos de uma eleição, são gerados vários registros
de votação contendo o nome do candidato e a quantidade de votos
(formato .csv) que ele obteve em uma urna de votação. Você deve
fazer um programa para ler os registros de votação a partir de um
arquivo, e daí gerar um relatório consolidado com os totais de cada
candidato.
*/
public class Principal {
	public static void main (String [] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o caminho do arquivo");
		String path = input.nextLine();
		
		Map <String, Integer> votes = new LinkedHashMap<>(); // LinkedHashMap aceita repetição e coloca na ordem que foram inseridos
		
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
			
			String line = bf.readLine(); // ler linha do arquivo
			
			while (line != null) {
				
				String [] fields = line.split(","); // separar os atributos num array
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				if (votes.containsKey(name)) {
					int votesSoFar = votes.get(name); // pegar o valor baseado na chave
					votes.put(name, count + votesSoFar); // adicionar ao LInkedHashMap o nome e quantidade de votos
				} else {
					votes.put(name, count);
				}

				line = bf.readLine();
			}
			
			System.out.println("Votos por candidato");
			for (String i : votes.keySet()) {
				System.out.println(i + ": " + votes.get(i));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
