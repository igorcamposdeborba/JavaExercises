package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class desduplicar {
	public static void main (String [] args) {
		/* (Eliminação de duplicatas) Escreva um programa que lê em uma série nomes e elimina duplicatas armazenando-os em um Set. 
		 Permita que o usuário procure um primeiro nome. */
		// 
		
		
		String [] names = {"Igor", "Luana", "Camilo", "Ana", "Igor"};
		// String [] names = {"Luana", "Camilo", "Igor", "Ana", "Igor", "Ana"};
		// String [] names = {"Igor", "Luana", "Ana", "Camilo", "Ana", "Andressa", "Ana", "Luana"};
		// String [] names = {"Luana", "Camilo", "Igor", "Ana", "Igor", "Ana", "Carla"};
		System.out.println(Arrays.toString(names));
		
		System.out.println("Nomes desduplicados:");
		unduplicateOne(names); // Collections
		unduplicateTwo(names); // Array -> List -> Set
		unduplicateThree(names); // Usar 2 arrays para desduplicar
		
	}
	
		// Maneira 1 de resolver: com AddAll de Collections
		static void unduplicateOne(String [] names) {
	
			Set<String> namesUnduplicated = new HashSet<String>();
			Collections.addAll(namesUnduplicated, names);
			
			System.out.println(namesUnduplicated);
		}
		
		
		// Maneira 2 de resolver: Usar laço for para passar Array -> para List -> para Set
		static void unduplicateTwo(String [] names) {
			
			List<String> namesList = new LinkedList<>();
			for (String i : names) {
				namesList.add(i);
			}
			
			Set<String> namesUnduplicated = new HashSet<String>();
			for (String i : namesList) {
				namesUnduplicated.add(i);
			}
			System.out.println(namesUnduplicated);
		}
		
		
		// Maneira 3 de resolver: usar variável temporária e copiar para um novo array desduplicado
		static void unduplicateThree(String [] names) throws NullPointerException {
			// exception
			if (names == null ) { 
				throw new NullPointerException("O array não pode estar vazio");
			}
			int dimensionDeduplicated = names.length;
			
			for (int i=0; i<names.length; i++) { // passar pelo caso base de comparação
				
				for (int j=i+1; j<names.length; j++) { // comparar com o próximo elemento
					
					if (names[i] != null && names[i].equalsIgnoreCase(names[j])) {
						names[j] = null;
						--dimensionDeduplicated;
					}
				}
			}
			
			// copiar para novo array desconsiderando null
			int indexToCopy = 0;
			String [] deduplicatedArray = new String[dimensionDeduplicated];
			for (int i=0; i<names.length; i++) { // passar por todo o array original
				if (names[i] != null) {
					deduplicatedArray[indexToCopy] = names[i]; // COPIAR para novo array sem duplicação e de tamanho correto
				}
			
				if (i < dimensionDeduplicated - 1) { // -1 porque o laço for começa em zero
					++indexToCopy; // incrementar índice que eu uso para copiar os valores não duplicados
				}
			}
			System.out.println(Arrays.toString(deduplicatedArray));
		}
}
