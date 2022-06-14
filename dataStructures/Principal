package dynamicDataApi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class Principal {
	public static void main (String [] args) {

		// criar LISTA dinâmica simplesmente encadeada para armazenar os produtos nessa lista
		try {
			System.out.println("--------- LISTA ---------");
			LinkedList <Produto> productList = new LinkedList <Produto>();
			
			// adicionar valores no objeto dentro da lista de produtos
			productList.addFirst(new Produto("Computer", 6000.00));
			productList.addLast(new Produto("Smartphone", 1200.90));
			productList.addLast(new Produto("Mouse", 130.20));
			productList.addLast(new Produto("Keyboard", 69.90));
			System.out.println(productList.toString());	
			
			productList.remove();
			System.out.println("Removido primeiro produto. \n" + productList.toString());	
			
			System.out.println("Primeiro produto da lista: " + productList.element());
			
			System.out.println("Número de elementos: " + productList.size());
			System.out.println(productList.toString());
		} catch (UnderflowException e) {
			e.printStackTrace();
		}
		
		
		// criar FILA dinâmica simplesmente encadeada para armazenar os produtos nessa queue
			System.out.println("\n--------- FILA ---------");
			
		try {
			LinkedBlockingQueue<Produto> productQueue = new LinkedBlockingQueue<Produto>();
			
			// adicionar valores no objeto dentro da fila de produtos
			productQueue.offer(new Produto("Computer", 6000.00));
			productQueue.offer(new Produto("Smartphone", 1200.90));
			productQueue.offer(new Produto("Mouse", 130.20));
			productQueue.offer(new Produto("Keyboard", 69.90));
			System.out.println(productQueue.toString());
			
			productQueue.remove();
			System.out.println("Removido primeiro produto. \n" + productQueue.toString());	
			
			System.out.println("Primeiro produto da fila: " + productQueue.element());
			
			System.out.println("Número de elementos: " + productQueue.size());
			System.out.println(productQueue.toString());
		} catch (UnderflowException e) {
			e.printStackTrace();
		}
			
		// criar PILHA dinâmica simplesmente encadeada para armazenar os produtos nessa stack
			System.out.println("\n--------- PILHA ---------");
		
		try {		
			Stack<Produto> productStack = new Stack<Produto>();
			
			productStack.push(new Produto("Computer", 6000.00));
			productStack.push(new Produto("Smartphone", 1200.90));
			productStack.push(new Produto("Mouse", 130.20));
			productStack.push(new Produto("Keyboard", 69.90));
			System.out.println(productStack.toString());
					
			productStack.pop();
			System.out.println("Removido último produto adicionado. \n" + productStack.toString());
			
			System.out.println("Produto do topo da pilha: " + productStack.peek());
			
			if (productStack.empty() == false)
				System.out.println("A pilha não está vazia. Ela contém" + productStack.size() + " elementos.");
			
			System.out.println(productStack.toString());
		} catch (UnderflowException e) {
			e.printStackTrace();
		}
		
	}
}
