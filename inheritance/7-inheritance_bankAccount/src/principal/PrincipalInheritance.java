package principal;

import entities.Associate;
import entities.Manager;
import entities.Person;
import entities.Provider;
import entities.Seller;
import entities.WorkMan;

public class PrincipalInheritance {
	public static void main(String [] args) {
		
		Provider provider1 = new Provider("Dell", "Avenida Assis Brasil, 2500", "51981569845", 1000.0, 300.0);
		System.out.println("Fornecedor cadastrado: " + provider1);
		
		provider1.getAmount();
		System.out.println("Saldo do fornecedor: R$ " + provider1.getAmount());
		
		Associate associate1 = new Associate("Ana Silva", "Rua Silveira 264", "14818168972", 15, 10000.0, 0.10F);
		
		System.out.println("Salario final do fornecedor: R$ " + String.format("%.2f", associate1.salary()));
		
		
		Manager manager1 = new Manager(provider1, associate1, 300.0);
		
		System.out.println("Salario do gerente: R$ " + String.format("%.2f", manager1.salary()));
		
		WorkMan workman1 = new WorkMan(new Person("Eduardo"), associate1, 3514.48, 0.10F);
		
		System.out.println("Salario do operario: R$ " + String.format("%.2f", workman1.salary()));
		System.out.println(workman1);
		
		// Revisar estrutura de herança da herança porque estou tendo que colocar duas vezes o nome e endereço. E não pega endereço da subclasse, só pega da superclasse.
		Seller seller1 = new Seller(new Person("Carla", "51984668710"), new Associate("Carla", "Rua da Republica 150", "51984668710", 10, 800.0, 0.20F), 4861.10, 0.15F);
		
		System.out.println(seller1);
	}
}
