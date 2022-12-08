import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Program {
	public static void main (String [] args) {
		
		/* Steps:
		 * 1) Convert number to binary String
		 * 2) String invert
		 * 3) Convert to integer
		 * */
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		UnaryOperator<String> invert = text -> new StringBuilder(text).reverse().toString();
		
		Function <String, Integer> binaryStringToInt = textBinary -> Integer.parseInt(textBinary, 2);
		
		
		nums.stream()
			.map(Integer::toBinaryString) // convert Integer to binary String
			.map(invert) // reverse with StringBuilder
			.map(binaryStringToInt) // convert to Int
			.forEach(System.out::println);
		
	}
}
