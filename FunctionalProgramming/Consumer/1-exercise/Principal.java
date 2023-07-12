package funcional1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Principal {
	public static void main (String [] args) {
		
		Consumer<String> palavra = System.out::print; // Consumer: porque eu vou transformar recebendo algo e não retornando nada, só mostrando em tela.
		palavra.accept("Frase de exemplo\n"); // accept serve para executar Consumer
		
		List<String> str = Arrays.asList("Teste ", "de ", "texto");
		
		str.stream().forEach(System.out::print); // :: chama um método. Isso é mais direto do que ter que fazer  str.stream().forEach(i -> System.out.print(i));
		
	}
	
	
}
