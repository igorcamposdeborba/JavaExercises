import java.util.Scanner;

public class Main {	
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite a quantidade de elementos da lista.");
		int dimension = input.nextInt();
		
		StaticList<Integer> query = new StaticList<Integer>(dimension);
		try {
			for (int i=0; i < dimension; i++) {
				System.out.println("Digite um número para inserir na lista:");
				query.insert(input.nextInt(), i);
			}
			
			int counter = 0;
			int i = 0;
			while (i < dimension) {
				counter = query.contaElementos(query.get(i));
				i++;
			}
			System.out.println("Número de elementos: " + counter);
			System.out.println("Valores: " + query.toString());
			
			
		} catch (OverflowException e) {
			System.err.println(e);
		} catch (UnderflowException e) {
			System.err.println(e);
		}
		
		input.close();
		
		/*
		int dimension = 5;
		StaticList<Integer> query = new StaticList<Integer>(dimension);
		try {
			query.insert(1, 0);
			query.insert(4, 1);
			query.insert(-2, 2);
			query.insert(3, 3);
			query.insert(10, 4);
			
			int counter = 0;
			
			int i = 0;
			while (i < dimension) {
				counter = query.contaElementos(query.get(i));
				i++;
			}
			System.out.println("Número de elementos: " + counter);
			
		} catch (OverflowException e) {
			System.err.println(e);
		} catch (UnderflowException e) {
			System.err.println(e);
		}	*/
	}
}
