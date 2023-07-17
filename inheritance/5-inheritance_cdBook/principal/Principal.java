package principal;

import entities.Book;
import entities.Cd;

public class Principal {
	public static void main(String [] args) {
		
		// String title, int releaseYear, int duration
		String title1 = "Armandinho";
		int releaseYear1 = 2018;
		int duration1 = 2;
		
		//  int pageCount
		String title2 = "Java: como programar";
		int releaseYear2 = 2014;
		int pageCount1 = 300;
		
		Cd c1 = new Cd(title1, releaseYear1, duration1);
		Book b1 = new Book(title2, releaseYear2, pageCount1);
		
		System.out.println(c1);
		System.out.println(b1);
	}
}
