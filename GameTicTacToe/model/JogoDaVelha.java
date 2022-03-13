package model;

import java.util.Scanner;

public class JogoDaVelha {
	int dimension; // salvar o tamanho do tabuleiro para ficar mais fácil para digitar e ler o código
	char [][] board; // array bidimensional para montar o tabuleiro
	boolean registerBoardCreated = false; // serve na validação para mostrar na tela se é a primeira vez que o tabuleiro está sendo criado.
	Player player; // composição porque um jogador faz compõe do jogo
	
	char x = 'x'; // peças para poder atribuir a cada jogador (1 = x e 2 = o)
	char circle = 'o'; 
	
	boolean player1Win = false;
	boolean player2Win = false;
	
	Scanner input = new Scanner(System.in);
	
	public JogoDaVelha(int dimension, Player player) {
		createBoard(dimension); // chamar método privado criar tabuleiro
		this.dimension = dimension;
		this.player = player; 
	}

	// fazer jogada
	public boolean play(int line, int column, char piece) {
		try {
			if (board[line][column] != 'x' && board[line][column] != 'o'){ // coloque a peça se não tiver peça naquele espaço que o usuário digitou
				if (piece == 'x') {
					board[line][column] = piece;
					return true;
				} else if (piece == 'o') {
					board[line][column] = piece;
					return true;
				}
			} else {
				// enquanto ele digitar errado se o espaço estiver preenchido, peça para digitar certo
				int temporaryLine = 0;
				int temporaryColumn = 0;
				while (board[line][column] == 'x' || board[line][column] == 'o') {
					System.err.println("Erro: espaço já preenchido anteriormente. Digite novamente a linha"); // mostrar mensagem de erro
					temporaryLine = input.nextInt() -1; // ! talvez corrigir com -1
					System.out.println("Digite novamente a linha");
					temporaryColumn = input.nextInt() -1;
					line = temporaryLine;
					column = temporaryColumn;
				}
				if (piece == 'x') {
					board[temporaryLine][temporaryColumn] = piece;
					return true;
				} else if (piece == 'o') {
					board[temporaryLine][temporaryColumn] = piece;
					return true;
				}
			}
		// exception se digitou um tamanho maior que o espaço do array
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Erro: você digitou uma linha ou coluna maior que o espaço do tabuleiro. Digite um número até " + board.length);
			int temporaryLine = input.nextInt() -1;
			System.out.println("Digite a coluna em que você gostaria de colocar a peça. Mínimo 1, máximo " + board.length);
			int temporaryColumn = input.nextInt() -1;
			
			while (temporaryLine > board.length || temporaryColumn > board.length) {
				System.err.println("Erro: você digitou uma linha ou coluna maior que o espaço do tabuleiro. Digite primeiro a linha, depois a coluna com números até " + board.length);
				temporaryLine = input.nextInt() -1;
				System.out.println("Digite a coluna em que você gostaria de colocar a peça. Mínimo 1, máximo " + board.length);
				temporaryColumn = input.nextInt() -1;
				
			}
			
			if (piece == 'x') {
				board[temporaryLine][temporaryColumn] = piece;
				return true;
			} else if (piece == 'o') {
				board[temporaryLine][temporaryColumn] = piece;
				return true;
			}
		}
			return false;
	}
		
	// Criar tabuleiro como um array pelo construtor
	private void createBoard(int dimension) {
		if (dimension > 2) {
			this.board = new char[dimension][dimension];
		} else {
			// tratar erro: se o usuário digitou um tamanho de tabuleiro menor que 3
			while (dimension < 3) {
				System.out.println("Digite um valor a partir de 3");
				dimension = input.nextInt();
				this.board = new char[dimension][dimension];
			}
		}
	}
		
	public void printBoard() {
		// Mostrar orientações na primeira jogada, antes de criar o tabuleiro
		if (registerBoardCreated == false) { // verificar se é a primeira vez que é criado o tabuleiro
			for (int i=0; i < board.length; i++) {
				for (int j=0; j < board[i].length; j++) {
					if (i == 0 && j == 0) {
						System.out.println("Os números abaixo representam as linhas e colunas que você deve digitar. Quando solicitado digite números inteiros:");
					}
					System.out.print((i+1) + "," + (j+1) + "|"); // Na introdução: imprimir a orientação com os números onde cada item fica dentro do array
				}
				System.out.println(); // quebrar a linha
				this.registerBoardCreated = true; // registrar que o tabuleiro foi criado para não cair nesse if e cair no else para não mostrar os números no tabuleiro
			}
		} else {
			for (int i=0; i < board.length; i++) {
				for (int j=0; j < board[i].length; j++) {
					System.out.print(board[i][j] + "|"); // imprimir os itens dentro do array (peças x ou o)
				}
				System.out.println(); // quebrar a linha
			}
		}
	}
	// verificar tabuleiro (lógica junta em uma parte dentro do método: contar junto validar)
	// verificar de forma dinâmica (tabuleiro sem limite de tamanho)
	public boolean verifyHorizontal() {		
		// System.out.println(Arrays.deepToString(board));  // testar visualmente se array ta preenchido

		int countX1 = 0; // contador para comparar se o número de peças preenchidas com x é igual ao tamanho do array da linha
		int countO1 = 0;
			
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) { // pergue o número do meio e no if compare com os dos do lado
				
				// verificar horizontal
				if (board[i][board.length - 1] == board[i][j] // pega última linha
					&& board[i][j] == 'x') { // pega a linha atual para ver se é a peça x
						countX1++; // contar o número de x daquela linha
						if (countX1 == board.length) { // validar se x é igual ao tamanho da linha
							player1Win = true;
							player.setPointsPlayer1(player.getPointsPlayer1() + 1);
							System.out.println("O jogador 1 " + player.getPlayer1() + " venceu porque preencheu a horizontal");
							System.out.println(player.toString());
							return true;
						}	
						
				} else if (board[i][board.length - 1] == board[i][j] // verificar horizontal
				    && board[i][j] == 'o') {
							countO1++;
							if (countO1 == board.length) { // testar se o tamanho 
								player2Win = true;
								player.setPointsPlayer2(player.getPointsPlayer2() + 1);
								System.out.println("O jogador 2 " + player.getPlayer2() + " venceu porque preencheu a horizontal");
								System.out.println(player.toString());
								return true;
							}
				}
				
			}
			countX1 = 0; // zerar contador ao trocar de linha i no array
			countO1 = 0;
		}
		
		return false;
	}
	
	// validar verticais (lógica separada em duas partes dentro do método: contar e depois validar)
	public boolean verifyVertical() {		
		// System.out.println(Arrays.deepToString(board));
		
		int countX1 = 0; // contador para comparar se o número de peças preenchidas com x é igual ao tamanho do array da linha
		int countO1 = 0;
			
			
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				
				// verificar vertical
				if (board[dimension - 1][j] == board[i][j] // pegar a última linha e comparar com a atual
					&& board[1][j] == board[i][j] // comparar a segunda linha com a atual
					&& board[i][j] == 'x') { // pega a linha atual para comparar se é a peça x
						countX1++;
						
				} else if (board[dimension - 1][j] == board[i][j]
					&& board[1][j] == board[i][j] // comparar a segunda linha com a atual
				    && board[i][j] == 'o') {
						countO1++;		
				}
			}
		}
		
		// comparar se o array da linha j está preenchido com todas as peças iguais
		if (countX1 == board.length) {
			if (player1Win == false)
				player1Win = true;
					player.setPointsPlayer1(player.getPointsPlayer1() + 1);
					System.out.println("O jogador 1 " + player.getPlayer1() + " venceu porque preencheu a vertical");
					System.out.println(player.toString());
					return true;
		} else if (countO1 == board.length) {
			if (player2Win == false)
				player2Win = true;
					player.setPointsPlayer2(player.getPointsPlayer2() + 1);
					System.out.println("O jogador 2 " + player.getPlayer2() + " venceu porque preencheu a vertical");
					System.out.println(player.toString());
					return true;
		}
		
		return false;
	}
	
	// Validar diagonais (lógica separada em duas partes dentro do método: contar e depois validar)
	public boolean verifyDiagonal() {
			int countX1 = 0; // Para salvar o x a fim de utilizar na comparação se o tamanho máximo da linha foi preenchida com a mesma peça
			int countO1 = 0;
			
			// validar diagonal esquerda para  direita
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (i == j) {	// identificar diagonal, que são valores iguais porque a matrix é quadrada
						if (board[i][j] == 'x') {
							countX1++;
						} else if (board[i][j] == 'o') {
							countO1++;
						}
					}
				}
			}
			// contar diagonal direita para esquerda
			int countX2 = 0;
			int countO2 = 0;			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (i == (board.length - j - 1) && board[i][j] == 'x') { // inverte diagonal. Começa do tamanho do array, e vai diminuindo cada posição
						countX2++;											 // e diminui 1 para o que array começa em zero
					} else if (i == (board.length - j - 1) && board[i][j] == 'x') {
						countO2++;
					}
				}
			}
			// validar diagonais: disparar resultado se o valor salvo da diagonal é igual ao tamanho do array quadrado (se o array fosse retangular, a lógica mudaria)
			if (countX1 == board.length || countX2 == board.length) { 
				if (player1Win == false)
					player1Win = true;
					player.setPointsPlayer1(player.getPointsPlayer1() + 1);
					System.out.println("O jogador 1 " + player.getPlayer1() + " venceu porque preencheu a diagonal");
					System.out.println(player.toString());
					return true;
			} else if (countO1 == board.length || countO2 == board.length) {
				if (player2Win == false)
					player2Win = true;
					player.setPointsPlayer2(player.getPointsPlayer2() + 1);
					System.out.println("O jogador 2 " + player.getPlayer2() + " venceu porque preencheu a diagonal");
					System.out.println(player.toString());
					return true;
			}
			

			return false;
		}
	
	// verificar empate
	public boolean verifyTie() {
		int countPieces = 0;
		if (registerBoardCreated == true) { // verificar se o tabuleiro foi criado
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 'x' || board[i][j] == 'o' || board[i][j] != 0) { // verificar se na posição do array ta preenchido
						countPieces++; // contar aquela peça
					}
				}
			}
			// validar se todos os espaços estão preenchidos do tabuleiro inteiro
			if (countPieces == board.length * dimension) { // multiplicar o tamanho do tabuleiro (ex.: 3)
				System.out.println("Ninguém venceu.");     // para considerar não só o tamanho da linha, mas o tabuleiro completo
				System.out.println(player.toString());
				return true;
			}
		}
		return false;
	}
}
