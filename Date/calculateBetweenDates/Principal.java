import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Principal {
	public static void main (String [] args) {
		
		
		// adicao e subtracao de datas
		LocalDate d04 = LocalDate.parse("2022-07-20"); // instanciar data
		LocalDate pastWeekLocalDate = d04.minusWeeks(1); // diminuir data com base em uma instanciada
		LocalDate nextWeekLocalDate = d04.plusWeeks(1);
		
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:30:26");
		LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);
		
		Instant d06 = Instant.parse("2022-07-20T01:30:26Z");
		Instant pastWeekInstantGlobal = d06.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstantGlobal = d06.plus(7, ChronoUnit.DAYS);
		
		System.out.println("\n" + d04);
		System.out.println("Past Week Local Date" + pastWeekLocalDate);
		System.out.println("Next Week Local Date" + nextWeekLocalDate);
	
		System.out.println("\n" + d05);
		System.out.println("Past Week Local Date Time" + pastWeekLocalDateTime);
		System.out.println("Next Week Local Date Time" + nextWeekLocalDateTime);
		
		System.out.println("\n" + d06);
		System.out.println("Past Week Instant Global" + pastWeekInstantGlobal);
		System.out.println("Next Week Instant Global" + nextWeekInstantGlobal);
	
		
		// duracao entre duas datas
		Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atTime(0, 0)); // comparar duas datas. Precisa definir os segundos com o atStratOfDay ou com o atTime
		Duration t2 = Duration.between(pastWeekLocalDateTime, d05); // comparar duas data
		Duration t3 = Duration.between(pastWeekInstantGlobal, d06);
		
		System.out.println("t1 dias " + t1.toDays()); // pegar o numero de dias entre as datas
		System.out.println("t2 dias " + t2.toDays()); 
		System.out.println("t3 dias " + t3.toDays());
		
		
	}
}
