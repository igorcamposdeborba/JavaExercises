package principal;

import entities.CheckingAccount;
import entities.Client;
import entities.SpecialAccount;

public class Principal {
	
	public static void main (String [] args) {
		
	Client client1 = new Client("Andressa");
	CheckingAccount checkingAccount1 = new CheckingAccount(client1, 5000.0F);
	
	
	System.out.println("Pessoa SEM conta: " + client1);
	System.out.println("Pessoa com conta: " + checkingAccount1);
	
	
	Client client2 = new Client("Bruno");
	float amountWithdraw = 2000.0f;
	SpecialAccount specialAccount1 = new SpecialAccount(client2, 8000.0F, 2000.0F);
	
	// checkingAccount1.setClient(client2); // exception: não deixa trocar o dono da conta do banco
	
	System.out.println("\n" + specialAccount1);
	System.out.println(specialAccount1.getClient() + " pode sacar R$ "+ amountWithdraw +"? " + specialAccount1.withdraw(amountWithdraw));
	
	System.out.println("Saldo depois da deducao: " + specialAccount1);
	
	}
}
