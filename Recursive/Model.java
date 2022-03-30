package Application;

import java.util.Arrays;

public class Model {
	
	
	public int exercicio2(int x) {
		if (x <= 1) { 
			return 1;
		} else {
			return x * 2 + exercicio2(x - 1);
		}
	}
	
	public int exercicio3(int a, int b) {
		if (b <= 1) {
			return b = a;
		} else {
			return exercicio3(b, a / b);
		}
	}
	
	public int exercicio4(int m, int n) {
		if (m == 0) 
			return n + 1;
		else if (n == 0) 
			return exercicio4(m - 1, 1);
		
		return exercicio4(m - 1, exercicio4(m, n -1));
	}
	
	// validar se digitou certo
	public int exercicio5(int n) throws IllegalArgumentException {
		if (n < 1) {
			throw new IllegalArgumentException();
		}
		return exercicio5Recursivo(n);
	}
	
	private int exercicio5Recursivo(int n) {
		if (n == 1) {
			return 1;
		}
		return n + exercicio5Recursivo(n - 1); // soma todos os valores do maior até o menor. Por isso -1 no método recursivo
	}
	
	
	public int exercicio6 (int [] v) throws IllegalArgumentException {
		if (v == null) {
			throw new IllegalArgumentException();
		}
		return exercicio6Recursivo(v, 0); // zero porque vou usar na validação e na recursão
	}
	
	private int exercicio6Recursivo (int [] v, int i) {
		if (i >= v.length) { // validar se array é maior ou igual a zero
			return 0;
		}
		return v[i] + exercicio6Recursivo(v, i + 1); // acrescenta 1 ao índice do array
	}
	
	
	public static int exercicio7 (int x) {
		int res;
		
		if (x < 4) {
			res = 3 * x;
		} else {
			res = 2 * exercicio7 (x - 4) + 5;
		}
		return res;
	}
	
	public boolean exercicio8(char [] word) throws IllegalArgumentException {
		if (word == null) {
			throw new IllegalArgumentException();
		}
		return isPalindrome(word, 0, word.length -1); // zero porque o array começa em zero pegar o último elemento
	}
	
	private boolean isPalindrome(char [] word, int i, int j) {
		if (i >= j) {
			return true;
		} 
		if (word[i] == word[j]) {
			return isPalindrome(word, i+1, j-1); // comparar o primeiro com o último elemento e acrescentar 1 e diminuir 1.
		}
		return false;
	}
	
	// imprimir array ao contrário
	public void exercicio9 (int[] array) throws IllegalArgumentException {
		if (array == null) throw new IllegalArgumentException();
		arrayInvertido(array, array.length - 1);
		
	}
	private void arrayInvertido(int [] array, int i) {
		if (i >= 0) {
			System.out.println(array[i]);
			arrayInvertido(array, --i); // decrementa 1 antes de usar como o índice do array. Na recursão ele começa da última chamada recursiva e volta
		}
	}
	
	
	// somar elementos de array de double bidimensional
	public double exercicio10 (double [][] array) throws IllegalArgumentException {
		if (array == null) throw new IllegalArgumentException();
		return somarArrayBidimensional(array, 0, 0); // array começa em zero
	}
	
	private double somarArrayBidimensional(double [][] array,int i, int j) {
		if (i >= array.length) return 0; // parar recursão se chegou ao fim da linha
		if (j >= array[i].length) return somarArrayBidimensional(array, i+1, 0); // pular linha na primeira coluna (se chegou no fim da coluna)
		
		return array[i][j] + somarArrayBidimensional(array, i, j+1); // somar a próxima coluna na mesma linha
	}
	
	
	// encontrar menor posição do array
	public int exercicio11(int[] array) throws IllegalArgumentException {
		if (array == null) throw new IllegalArgumentException();
		return encontraPosicaoMenorValor(array, 1, 0); // i começará em 1 para não comparar com ela mesma, e a posição começa em zero
	}
	
	private int encontraPosicaoMenorValor(int [] array, int i, int posicaoMenor) {
		if (i >= array.length) return posicaoMenor;
		if (array[i] < array[posicaoMenor]) {
			posicaoMenor = i;
		}
		return encontraPosicaoMenorValor (array, i+1, posicaoMenor);
	}
	
	
	// imprimir matriz diagonal
	public void exercicio12(int[][] array) throws IllegalArgumentException, MatrixNotPossibleException {
		if (array == null) {
			throw new IllegalArgumentException();
		}
		if (array.length != array[0].length) { // verificar se é matriz quadrada. Quando o nº de Linhas diferente no nº de colunas, lança uma exception
			throw new MatrixNotPossibleException(); // exception personalizada
		}
		printPrimaryDiagonal(array, 0);
	}
	
	private void printPrimaryDiagonal(int[][] array, int i) {
		if (i < array.length) {
			System.out.println(array[i][i]);
			printPrimaryDiagonal(array, i+1);
		}
	}
	
	// converter número binário para decimal
	public int exercicio13(String binaryNumber) throws IllegalArgumentException {
		if (binaryNumber == null || binaryNumber.length() != 8) {
			throw new IllegalArgumentException();
		}
		return binaryToDecimal(binaryNumber, 0);
	}
	
	private int binaryToDecimal(String binaryNumber, int i) {
		if (i >= binaryNumber.length())
			return 0;
		char digito = binaryNumber.charAt(binaryNumber.length() -1 -i);
		if (digito == '1')
			return (int) (Math.pow(2, i) + binaryToDecimal(binaryNumber, i + 1));
		
		return binaryToDecimal(binaryNumber, i + 1);
	}
	
	// Encontrar número no array
	public boolean exercicio14 (int[] array, int n) throws IllegalArgumentException {
		if (array == null)
			throw new IllegalArgumentException();
		return exercicio14Recursivo (array, 0, n);
	}
	
	private boolean exercicio14Recursivo (int [] array, int i, int n) {
		if (i >= array.length)
			return false;
		if (array[i] == n) {
			return true;
		}
		return exercicio14Recursivo(array, i+1, n);
	}
	
	// encontrar número primo
	public boolean exercicio15 (int n) {
		if (n <= 1)
			return false;
		return exercicio15Recursivo (n, 2);
	}
	private boolean exercicio15Recursivo (int n, int i) {
		if (n % 2 == 0) // se tiver um número divisível, não é um número primo
			return false;
		if (i > n/2) // se o i passar da metade e não encontrar divisor, este é um número primo
			return true;
		return exercicio15Recursivo(n, i+1);
	}
	
	// inverter string
	public String exercicio16 (String originalString) throws IllegalArgumentException {
		if (originalString == null)
			throw new IllegalArgumentException();
		return invertString(originalString, 0, "");
	}
	private String invertString (String originalString, int i, String inverted) {
		if (i >= originalString.length())
			return inverted;
		
		inverted = originalString.charAt(i) + inverted;
		return invertString (originalString, i+1, inverted);
	}
	
}

