import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Principal {
	public static void main (String [] args) {
		
		LocalDate d04 = LocalDate.parse("2022-07-20");
		LocalDateTime d05 = LocalDateTime.parse("2022-07-20T01:35:26");
		Instant d06 = Instant.parse("2022-07-20T01:30:17Z"); // horario global utc
		
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault()); // horario local do computador do usuario
		DateTimeFormatter dtf4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter dtf5 = DateTimeFormatter.ISO_INSTANT;
		
		System.out.println("LocalDate " + d04.format(dtf1)); // formatar data local
		System.out.println("LocalDate " + dtf1.format(d04)); // formatar data local
		
		System.out.println("LocalDate " + dtf1.format(d05)); // formatar date local
		System.out.println("LocalDate " + dtf2.format(d05)); // formatar date e hora local
		
		System.out.println("Instant date time formatacao personalizada " + dtf3.format(d06)); // formatar data e hora global (utc)
		
		System.out.println("LocalDateTime formatado na ISO: " + dtf4.format(d05));
		System.out.println("Instant date time formatado na ISO: " + dtf5.format(d06));
		
	}
}
