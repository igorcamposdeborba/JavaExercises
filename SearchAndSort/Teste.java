
public class Teste {
	
	// Pesquisa binária recursiva (somente array ordenado)
	public int pesquisaBinaria(int [] array, int searchValue) throws IllegalArgumentException {
		if (array == null) { // tratar array vazio
			throw new IllegalArgumentException();
		}
		return pesquisaBinariaRecursiva(array, 0, array.length -1, searchValue);
		
	}

	private int pesquisaBinariaRecursiva(int array[], int inf, int sup, int searchValue) {
		if (inf <= sup) {
			int mid = (inf + sup) / 2;
			if (array[mid] == searchValue)
				return mid;
			else if (searchValue > array[mid])
				return pesquisaBinariaRecursiva(array, mid + 1, sup, searchValue);
			else
				return pesquisaBinariaRecursiva(array, inf, mid - 1, searchValue);
		} 
		return -1;
	}
		
	
	// ordenar por seleção direta recursiva
	public int [] selecaoDireta(int [] array) throws IllegalArgumentException {
		if (array == null) { // tratar array vazio
			throw new IllegalArgumentException();
		}
		return selecaoDiretaRecursiva(array, 0, 0, 0);
	}
	private int [] selecaoDiretaRecursiva(int [] array, int i, int j, int min){
				
		if (i < array.length -1) { // testar se está dentro do tamanho do array
			min = i;
			if (j < array.length) { // testar se está dentro do tamanho do array
				
				if(array[j] < array[min]) {
					min = j;
					
					int aux = array[i];
					array[i] = array[min];
					array[min] = aux;
				}
				return selecaoDiretaRecursiva(array, i, j+1, min); // recursão para verificar cada casa da linha atual
			}
			return selecaoDiretaRecursiva(array, i+1, i+1, min); // recursão para andar para o lado
			
		}
		
		return array;
	}
	
	
	// ordenar por inserção direta recursiva (ordenação estável: preserva ordem de elementos iguais).
	public int [] insercaoDireta(int [] array) throws IllegalArgumentException {
		if (array == null) { // tratar array vazio
			throw new IllegalArgumentException();
		}
		return insercaoDiretaRecursiva(array, 0, array.length-1);
	}
	private int [] insercaoDiretaRecursiva(int [] array, int i, int j){ // ! CORRIGIR bug com valor -3 em diante no array
		if (i < array.length) { // testar se está dentro do tamanho do array
			insercaoDiretaRecursiva(array, i+1, j); // percorrer array
			ordenarInsercaoDireta(array, i, j-1, array[j]); // array[j] é o primeiro elemento não ordenado
		}
		return array;
	}
	
	private int [] ordenarInsercaoDireta(int [] array, int i, int j, int b) {
		j = i;
		b = array[i];
		
		if ((j>0 
			&& (array[j-1] > b))) {
			
			array[j] = array[j-1];
			j--;
			ordenarInsercaoDireta(array, i, j-1, b);
		}
		array[j] = b;
		insercaoDiretaRecursiva(array, i+1, j);
		
		return array;
	}
}
