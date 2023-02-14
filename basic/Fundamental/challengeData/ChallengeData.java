package basic.challengeData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChallengeData {
	
	// Exercício: formate uma data baseado em números inteiros
	
	public static void main (String [] args) {
		// opção 1 com classe funcional
		
		int day = 01;
		int month = 02;
		int year = 94;
		
		String formattedData = Data.getData(day, month, year);
		
		System.out.println(formattedData);
		
		
		// Opção 2 com Simple Date format
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String yearStr = null;
		
		if (String.valueOf(year).length() == 2) {
			yearStr = "19" + year;
		} else {
			yearStr = Integer.toString(year);
		}
		
		
		try {
			Date data = sdf.parse(day + "/" + month + "/" + yearStr);
			System.out.println(sdf.format(data)) ;
			
		} catch (ParseException e){
			e.printStackTrace();
		}
		
	
	}
}
