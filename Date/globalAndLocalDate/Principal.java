import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {

	
	public static void main (String [] args) {
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // formatar data e hora
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // formatar data e hora
		
		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();
		LocalDate d04 = LocalDate.parse("1994-06-01");
		LocalDateTime d05 = LocalDateTime.parse("1994-06-01T15:21:26");
		Instant d06 = Instant.parse("1994-06-01T15:21:26Z");
		Instant d07 = Instant.parse("1994-06-01T15:21:26-03:00");
		LocalDate d08 = LocalDate.parse("01/06/1994", dtf1); // formatar data
		LocalDateTime d09 = LocalDateTime.parse("01/06/1994 01:30", dtf2); // formatar data e hora
		LocalDate d10 = LocalDate.of(2022, 07, 20);
		LocalDateTime d11 = LocalDateTime.of(2022, 07, 20, 01, 30);
		
		System.out.println("LocalDate: \t\t\t" + d01);
		System.out.println("LocalDateTime: \t\t\t" + d02);
		System.out.println("Instant GlobalDateTime: \t" + d03);
		System.out.println("LocalDate: \t\t\t" + d04);
		System.out.println("LocalDate: \t\t\t" + d05);
		System.out.println("Instant GlobalDateTime horario de greenwich: \t" + d06);
		System.out.println("Instant GlobalDateTime horario de SP: \t\t" + d07);
		System.out.println("LocalDate com data formatada: \t\t\t" + d08);
		System.out.println("LocalDate com data e hora formatada: \t\t" + d09);
		System.out.println("LocalDate com data: \t\t\t\t" + d10);
		System.out.println("LocalDate com data e hora: \t\t\t" + d11);

		
	}
}
