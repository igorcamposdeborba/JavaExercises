package principal;

import entities.Ticket;
import entities.TicketVip;

public class Principal {
	public static void main (String [] args) {
		
		TicketVip ticketVip1 = new TicketVip(100.00F , 200.99F);
		
		System.out.println("Pessoa 1 - " + ticketVip1);
		
		Ticket ticket1 = new Ticket(50.00F);
		System.out.println("Pessoa 2 - " + ticket1);		
	}
}
