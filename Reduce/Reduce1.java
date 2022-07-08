import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class Reduce1 {
	public static void main (String [] args) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		BinaryOperator<Integer> sum = (accumulator, i) -> accumulator + i;
		
		int total1 = nums.stream().reduce(sum).get();
		
		System.out.println(total1);
		
		Integer total2 = nums.stream().reduce(100, sum); // considera o valor inicial 100 somente no primeiro acumulador
		Integer total3 = nums.parallelStream().reduce(100, sum); // considera o valor inicial 100 várias vezes
		
		System.out.println(total2);
		System.out.println(total3);
		
		
		nums.stream()
			.filter(i -> i > 5) // filtra notas maiores que 5
			.reduce(sum) // acumula baseado no número anterior do acumulador
			.ifPresent(System.out::println); // ifPresent é um método contém
		
	}
}
