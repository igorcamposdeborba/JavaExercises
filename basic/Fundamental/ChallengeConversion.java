package basic;

import java.util.Scanner;

public class ChallengeConversion {
	public static void main (String [] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Digite o primeiro salario");
		String firstInputSalary = input.next().replace(",", "."); 
		System.out.println("Digite o segundo salario");
		String secondInputSalary = input.next().replace(",", "."); 
		System.out.println("Digite o terceiro salario");
		String thirdInputSalary = input.next().replace(",", ".");
		
		double firstSalary = Double.parseDouble(firstInputSalary);
		double secondSalary = Double.parseDouble(secondInputSalary);
		double thirdSalary = Double.parseDouble(thirdInputSalary);
		
		double average = (firstSalary + secondSalary + thirdSalary) / 3.0;
		
		System.out.println("Media :" + average);
		
		input.close();
	}
}
