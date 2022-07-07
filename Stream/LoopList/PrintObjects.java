package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class PrintObjects {
	public static void main (String [] args) {
		
		//List<String> approveds = Arrays.asList("Igor", "Luiza", "Roberto", "Laura"); // alternative
		List<String> approved = new ArrayList<String>();
		String [] arr = {"Igor", "Luiza", "Roberto", "Laura"};
		
		// moving from array from ArrayList
		for (int i=0; i<arr.length; i++) {
			approved.add(arr[i]);
		}
		
		// print each list element
		for (int i=0; i < approved.size(); i++) {
			System.out.println(approved.get(i));
		}
		
		// FORMAS DE PERCORRER UMA LISTA (for each, iterator e stream)
		System.out.println("\nFOR EACH:");
		// for each
		for (String i : approved) {
			System.out.println(i);
		}
		
		
		System.out.println("\nITERATOR:");
		// ! percorrer lista pelo iterator
		Iterator<String> iterator = approved.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		System.out.println("\nSTREAM:");
		// ! Stream (sequência de dados/objetos) - paradigma funcional
		Stream<String> stream = approved.stream();
		stream.forEach(System.out::println);
		
	}
}
