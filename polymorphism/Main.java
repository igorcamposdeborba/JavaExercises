import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Employee> employee = new ArrayList<>(); // ArrayList with associates

        System.out.println("Digite o numero de associados para cadastrar");
        int quantityAssociates = input.nextInt();

        // add associate inner
        for (int index = 0; index < quantityAssociates; index++) {
            System.out.println("\nO "+ (index+1) +"º funcionario eh terceirizado? (S/N)");
            char outsourced = input.next().charAt(0);
            input.nextLine(); // buffer of char

            System.out.print("Nome: ");
            String name = input.nextLine();
            System.out.print("Horas por semana: ");
            int hours = input.nextInt();
            input.nextLine();// buffer of int
            System.out.print("Remuneracao por hora: ");

            double valuePerHour = 0.0;
            // Validate if user typed right with , the valuePerHour
            String temporaryValuePerHour = input.nextLine();

            // valuePerHour = Double.parseDouble(temporaryValuePerHour);
            if (temporaryValuePerHour.contains(",")) {
                // temporaryValuePerHour.replace("(\\.)(\\d{2})$", ",$1"); // Mask: replace , to .
                temporaryValuePerHour.replace(",", ".");
            }
            valuePerHour = Double.valueOf(temporaryValuePerHour); // convert String to double


            Employee emp = null;
            // Validate if is an outsourced associate
            if (outsourced == 'S' || outsourced == 's') {
                System.out.print("Cobranca adicional: ");
                double additionalCharge = input.nextDouble();
                emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge); // instantiate subclass: polymorphism

            } else if (outsourced == 'N' || outsourced == 'n') {
                emp = new Employee(name, hours, valuePerHour); // instantiate superclass: polymorphim
            }
            employee.add(emp); // add inner arrayList
        }

        for (Employee i : employee) {
            System.out.println("Pagamentos:");
            System.out.println(i.getName() + " - R$ " + String.format("%.2f", i.payment()));
        }

        input.close();

    }
}
