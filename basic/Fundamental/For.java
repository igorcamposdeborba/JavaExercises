package basic;

public class For {

	public static void main(String[] args) {
		
		String dimension = "######";
		
		for (String i="#"; !i.equals(dimension); i = i + "#") {
			System.out.println(i);
		}

	}

}
