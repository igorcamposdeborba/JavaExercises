package compositionEcommerce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		Scanner input = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite os dados do cliente");
		System.out.print("Nome: ");
		String name = input.nextLine();
		System.out.print("E-mail: ");
		String email = input.nextLine();
		System.out.print("Data de nascimento (dd/MM/yyyy): ");
		Date birthDate = null;
		try {
			birthDate = sdf.parse(input.next());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Client client = new Client(name, email, birthDate); // instantiate client object
		
		
		System.out.println("\nDigite os dados do pedido de compra");
		System.out.println("Status: ");
		System.out.print("PENDING_PAYMENT\n"
							   + "PROCESSING\n"
							   + "SHIPPED\n"
							   + "DELIVERED");
		// converter para String a representação do tipo primitivo com o método valueOf
		OrderStatus status = OrderStatus.valueOf(input.next().toUpperCase()); 
		
		Order order = new Order(client, new Date(), status); // instantiate order object
		
		System.out.print("Quantitade de pedidos");
		int quantityOrder = input.nextInt();
		for (int i=0; i<quantityOrder; i++) {
			input.nextLine(); // buffer of int from the second pass of loop
			System.out.println("Digite os dados do " + (i+1) + "o pedido: ");
			System.out.print("Nome do produto: ");
			String productName = input.nextLine();
			System.out.print("Preco do produto: ");
			double productPrice = input.nextDouble();
			System.out.print("Quantidade do produto: ");
			int productQuantity = input.nextInt();
			
			Product product = new Product(productName, productPrice); // instantiate object of product
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, product); // instantiate Order item
			
			order.addItem(orderItem); // add order item into order
			
		}
		System.out.println("\nResumo do pedido de compra");
		System.out.print(order);
		
		input.close();
	}
}
