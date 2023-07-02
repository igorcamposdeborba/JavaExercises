package recursao;

public class recursion1 {
/* Localize o(s) erro(s) no seguinte método recursivo e explique como corrigi-lo(s). Esse método deve encontrar a soma dos valores de 0 a n.
 public int sum(int n) {
	if (n == 0)
	return 0;
	else
	return n + sum(n);
}
 */
	public static void main (String [] args) {
		
		System.out.println(sum(3));;
	}
	
	static int sum(int n) {
		if (n == 0) {
			return 0;
		} if (n >= 100) {
			 return n;
		
		} else {
			return n + sum(n - 1); // 3 / + 2 / + 1
		}
	}
}
