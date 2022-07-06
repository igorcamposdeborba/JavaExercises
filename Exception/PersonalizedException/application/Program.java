package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

/*Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
novamente a reserva com os dados atualizados. O programa não deve aceitar dados
inválidos para a reserva, conforme as seguintes regras:
- Alterações de reserva só podem ocorrer para datas futuras
- A data de saída deve ser maior que a data de entrada
 */
public class Program {
	public static void main (String [] args) {
		
		Scanner input = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number ");
			int room = input.nextInt();
			System.out.print("Check-in date (dd/MM/aaaa) ");
			Date checkIn = sdf.parse(input.next());
			System.out.print("Check-out date (dd/MM/aaaa) ");
			Date checkOut = sdf.parse(input.next());
			
		
			Reservation reserve = new Reservation(room, checkIn, checkOut); // instantiate reserve
			System.out.println("Reservation: " + reserve);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Room number ");
			room = input.nextInt();
			System.out.print("Check-in date (dd/MM/aaaa) ");
			checkIn = sdf.parse(input.next());
			System.out.print("Check-out date (dd/MM/aaaa) ");
			checkOut = sdf.parse(input.next());
			
			reserve.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reserve);
		
		} catch (ParseException e) {
			System.err.println("Invalid date format");
		} catch (DomainException e) {
			System.err.println("Error in reservation: " + e.getMessage()); // show excpetion as personalized exception
		} catch (InputMismatchException e) {
			System.err.println("Invalid input format");
		}
		
		input.close();
	}
}
