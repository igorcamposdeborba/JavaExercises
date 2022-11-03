import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		// Máscara para a data com SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o nome do departamento ");
		String department = input.nextLine();
		System.out.println("Dados do colaborador");
		System.out.print("Nome ");
		String name = input.nextLine();
		System.out.println("Nivel (digite uma das opcoes abaixo)");
		System.out.println("JUNIOR\n"
				           + "MID_LEVEL\n"
				           + "SENIOR");
		String level = input.nextLine().toUpperCase();
		System.out.print("Salario base: ");
		double baseSalary = 0.0;

		try { // convert point to dot
			baseSalary = input.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Digite novamente o salario: ");
			String tempFormatSalary = input.nextLine();
			tempFormatSalary.replace("\\.(?=[^.]*$)", ","); // convert from . to ,
			baseSalary = Double.parseDouble(tempFormatSalary); // convert Strigng to double
		}
		System.out.println("log: " + baseSalary);
		input.next();
		System.out.print("Quantos contratos o colaborador tem? ");
		int quantityContracts = input.nextInt();
		
		// Value of transforma em string o tipo WorkerLevel. É uma instância de WorkerLevel que eu digitei
		// Department é um objeto com o nome do departamento
		Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Department(department)); // instantiate object department
		
		for (int i=0; i<quantityContracts; i++) {
			System.out.println("Digite o contrato numero " + (i+1));			
			System.out.print("Data (dd/MM/yyyy) ");
			Date contractDate = null;
			
			try {
				contractDate = sdf.parse(input.next());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			System.out.print("Remuneracao por hora ");
			double valuePerHour = input.nextDouble();
			System.out.print("Duracao do contrato (horas) ");
			int hours = input.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours); // instantiate object contract
			worker.addContract(contract); // add into worker the contract
		}
		
		System.out.print("\nDigite o mes e ano para calcular a salario daquele mes (MM/yyyy): ");
		String monthAndYear = input.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());		
		System.out.println("Salario para o ano " + month + ": " + String.format("%.2f", worker.income(year, month)));
		
		input.close();
	}
}
