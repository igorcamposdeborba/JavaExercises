package genericsAndFile;

import java.util.List;

public class CalculationService {
	
	// comparar o item atual com o anterior num laço for para descobrir o maior valor
	// static: método static mantém o valor padrão para a classe, não precisando instanciar objeto
	// extends: já que eu uso o método compareTo da classe Comparable, eu preciso extends (herder) o método dessa classe Comparable
	// List <T>: eu recebo uma lista de tipo genérico
	public static <T extends Comparable<T>> T max(List<T> list) throws IllegalArgumentException {
		if (list.isEmpty() == true) {
			throw new IllegalArgumentException("Lista vazia. Popule a lista antes de saber o valor maximo dela");
		}
		
		T max = list.get(0); // contador: para pegar o primeiro valor para comparar 
		
		for (T i : list) {
			if (i.compareTo(max) > 0) {
				max = i; // colocar o maior valor substituindo o valor de max
			}
		}
		
		return max;
	}
}
