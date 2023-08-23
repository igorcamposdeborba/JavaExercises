package principal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal7 {
	public static void main (String [] args) {
		
	// 7) nro-elementos: recebe uma lista qualquer e retorna o número de elementos na lista obs.: não usar a função length
		int [] list = {2, 0, 8, 5, 4, 7, 9};

	// Opção 1:
		Integer size = Arrays.stream(list)
								.reduce(0, (accumulator, elementActual) -> accumulator + 1);
		
		System.out.println("Contem o tamanho do array? " + size + " elementos");
	    
	}
}
