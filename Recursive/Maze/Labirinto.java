package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Labirinto {
	private BufferedReader br;
	private char[][] arrayLabirinto; // labirinto em array bidimensional	
	private int linhaAnterior = 0;
	private int colunaAnterior = 0;
	
	public Labirinto(String fileName) {
		try {
			carregaLabirinto(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ler arquivo e criar labirinto num array bidimensional
	public char[][] carregaLabirinto(String fileName) throws FileNotFoundException, IOException, NumberFormatException {
		try {
			// abrir arquivo para leitura e preencher array com as posicoes do labirinto
			FileReader fr = new FileReader(fileName); // Ler arquivo
			br = new BufferedReader(fr);// Ler conteúdo do arquivo

			// Converter para int o número de linhas e colunas do array bidimensional que
			// será criado
			String line = br.readLine();
			int linha = Integer.parseInt(line); // salvar e ignorar primeira linha do arquivo porque é o cabeçalho

			line = br.readLine();
			int coluna = Integer.parseInt(line);

			arrayLabirinto = new char[linha][coluna];
			for (int i = 0; i < arrayLabirinto.length; i++) {
				String line1 = br.readLine();
				for (int j = 0; j < arrayLabirinto[i].length; j++) {
					arrayLabirinto[i][j] = line1.charAt(j);
				}
			}
			System.out.println(Arrays.deepToString(arrayLabirinto));
			br.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arrayLabirinto;
	}

	// verificar se existe caminho ou não na matriz
	public boolean verificarCaminho(String fileName) throws IOException, IllegalArgumentException {
		if (fileName == "") { // mostrar mensagem se não há arquivo
			throw new IOException();
		}
		try {
			arrayLabirinto = carregaLabirinto(fileName); // instanciar labirinto num array bidimensional pelo método carregaLabirinto

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (arrayLabirinto == null) { // mostrar mensagem se array está nulo
			throw new IllegalArgumentException();
		}
		return verificarCaminho(arrayLabirinto, 0, 0); // verificar se existe um labirinto criado
	}
	
	
	private boolean verificarCaminho(char[][] arrayLabirinto, int i, int j) {
		
		// verificar se ganhou
		if (arrayLabirinto[i][j] == 'D') {
			return true;
		}
		
		// testar se não encontrou caminho com D
		if (i < 0 && j < 0 
			&& i > arrayLabirinto.length && j > arrayLabirinto[i].length
			|| i == arrayLabirinto.length && j == arrayLabirinto[i].length && arrayLabirinto[i][j] != 'D') { 
			return false;
		}
		

		// Direita
		if ((j+1) < arrayLabirinto[0].length && arrayLabirinto[i][(j + 1)] != 'X' // testar se tá dentro do tabuleiro e se tem espaço livre
			&& j != colunaAnterior
			|| i == 0 & j == 0) {
			this.colunaAnterior = j;
			return verificarCaminho(arrayLabirinto, i, (j+1)); // direita
		}
		// Esquerda
		if ((j-1) >= 0 && arrayLabirinto[i][(j - 1)] != 'X' // testar se tá dentro do tabuleiro e se tem espaço livre
			&& arrayLabirinto[i][(j)] != arrayLabirinto[i][(j-1)]
			&& (j+1) != colunaAnterior) { 
			this.colunaAnterior = j;
			return verificarCaminho(arrayLabirinto, i, (j-1)); // esquerda
		}
		
		// Baixo
		if ((i+1) < arrayLabirinto.length && arrayLabirinto[(i + 1)][j] != 'X' // testar se tá dentro do tabuleiro e se tem espaço livre
			&& (i+1) != linhaAnterior) { 
			this.linhaAnterior = i;
			return verificarCaminho(arrayLabirinto, (i+1), j); // baixo
		}
		if (linhaAnterior == 1 && colunaAnterior > 1) {
			if ((i+1) < arrayLabirinto.length && arrayLabirinto[(i + 1)][j] != 'X' ) {  // testar se tá dentro do tabuleiro e se tem espaço livre
				this.linhaAnterior = i;
				return verificarCaminho(arrayLabirinto, (i+1), j); // baixo
			}
		}
		// Cima
		if ((i-1) >= 0 && arrayLabirinto[(i - 1)][j] != 'X'
			&& i != arrayLabirinto.length
			&& i != linhaAnterior) {
			this.linhaAnterior = i;
			return verificarCaminho(arrayLabirinto, (i-1), j); // cima
		}
		
		return false;
	
	}

}
