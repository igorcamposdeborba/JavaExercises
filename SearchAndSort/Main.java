import java.util.Arrays;

public class Main {
			
	public static void main (String [] args) {
		
		System.out.println("Array original ordenado: [-2, 1, 4, 4, 5, 8, 9]");
		int [] array1 = {-2, 1, 4, 4, 5, 8, 9};
		int [] array2 = {1, -2, 8, 4, 9, 5, 55, 87, -3, -1, 3, 6, 4};
		int [] array3 = {1, -2, 8, 4, 9, 5, 55, 87, -3, -1, 3, 6, 4};
		
		
		Teste modulo = new Teste();
		
		int searchValue = 1;
		// Pesquisa binária recursiva (somente array ordenado)
		int resultado1 = modulo.pesquisaBinaria(array1, searchValue);
		
		if (resultado1 < 0) {
			System.out.println("Não encontrado o valor " + searchValue + " na pesquisa binaria");
		}
		else {
			System.out.println("Pesquisa binária: encontrado o valor " + searchValue + " na posição " + resultado1 + " do array.");
		}
		System.out.println("____________________________________________________");
		System.out.println("Array original desordenado:    [1, -2, 8, 4, 9, 5, 55, 87, -3, -1, 3, 6, 4]\n");
		// Seleção direta recursiva (array desordenado)
		int [] resultado2 = modulo.selecaoDireta(array2);
		System.out.println("Seleção direta recursiva:      " + Arrays.toString(resultado2));
		
		
		// Inserção direta recursiva (array desordenado
		int [] resultado3 = modulo.insercaoDireta(array3);
		System.out.println("Inserção direta recursiva:     " + Arrays.toString(resultado3));
		
	}
}
