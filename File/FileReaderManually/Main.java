package fileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Main {
	public static void main (String [] args) {
		Locale.setDefault(Locale.US);
	
		// Método manual:
		// FileReader (stream - sequência de leitura de um arquivo)
		// BufferedReader (buffer de memória que otimiza o FileReader)
		String path = "src\\fileReader\\in.txt"; // caminho do arquivo
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(path); // Stream: sequência de leitura do arquivo neste caminho
			br = new BufferedReader(fr); // instanciar bufferedReader. É uma camada mais abstrada
			
			String line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.err.println("Erro: " + e.getMessage());
		
		} finally {
			try { // se acontecer algum erro abaixo no fechamento das streams, captura o erro no catch
				if (br != null) { // fechar stream somente se ela foi instanciada
					br.close();
				}
				if (fr != null) { // fechar stream somente se ela foi instanciada
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	}
}
