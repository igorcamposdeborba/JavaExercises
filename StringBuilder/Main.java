package StringBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		
		SimpleDateFormat formatDataMask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // mascara SimpleDateFormat para a data
		
		Post post1 = null;
		try {
			post1 = new Post(formatDataMask.parse("01/06/2023 13:08:29"), "Tramonto", "Viagem para Venice", 36);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Comment comment1 = new Comment("Otima viagem");
		Comment comment2 = new Comment("Uau, que linda a paisagem");
		
		Post post2 = null;
		try {
			post2 = new Post(formatDataMask.parse("14/08/2022 08:04:32"), "Bom-dia gente", "Vejo voces amanha", 5);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Comment comment3 = new Comment("Bom dia");
		Comment comment4 = new Comment("Manda um beijo para a vo");
		
		
		post1.addComment(comment1);
		post1.addComment(comment2);
		post2.addComment(comment3);
		post2.addComment(comment4);
		
		System.out.println(post1);
		System.out.println(post2);
		
	}
}
