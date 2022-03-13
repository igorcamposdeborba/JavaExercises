package application;

import java.util.Scanner;

import model.JogoDaVelha;
import model.Player;

public class Main {
	public static void main (String [] args) {
		Scanner input = new Scanner(System.in);

		// idenfificar jogadores e tamanho do tabuleiro
		
		System.out.println("Digite o nome do jogador 1:");
		String player1 = input.nextLine();
					
		System.out.println("Digite o nome do jogador 2:");
		String player2 = input.nextLine();
		
		Player player = new Player(player1, player2);
		

		// iniciar tabuleiro e jogadas
		boolean replay = false;	
		do {

			System.out.println("Digite o tamanho do tabuleiro (formato numérico maior ou igual a 3)");
			int dimension = input.nextInt();

			JogoDaVelha game = new JogoDaVelha(dimension, player); // criar tabuleiro

			// iniciar jogadas
			int turnCount = 0; // contador para ser usado na conta se é a vez do player 1
			boolean turnPlayer1 = true; // lógica boolean para ser usado na conta se é a vez do player 1

			while (game.verifyHorizontal() == false && game.verifyVertical() == false && game.verifyDiagonal() == false) {

				turnPlayer1 = (turnCount % 2 == 0); // turno do jogador par (player 1)
				if (turnPlayer1 == true) {

					game.printBoard();
					System.out.println("Jogador " + player.getPlayer1()
							+ ", digite a linha em que você gostaria de colocar a peça. Mínimo 1, máximo "
							+ (dimension));
					int linePlayer1 = input.nextInt();
					System.out.println("Jogador " + player.getPlayer1()
							+ ", digite a coluna em que você gostaria de colocar a peça. Mínimo 1, máximo "
							+ (dimension));
					int columnPlayer1 = input.nextInt();
					turnCount += 1;

					// tratar dado: caso o usuário digite 0, colocar 1 por causa do array
					if (linePlayer1 == 0)
						linePlayer1 = 1;
					if (columnPlayer1 == 0)
						columnPlayer1 = 1;

					game.play(linePlayer1 - 1, columnPlayer1 - 1, 'x'); // tratar dado: diminui 1 porque o array começa em zero
																							

				} else {
					game.printBoard();

					System.out.println("Jogador " + player.getPlayer2()
							+ ", digite a linha em que você gostaria de colocar a peça. Mínimo 1, máximo "
							+ (dimension));
					int linePlayer2 = input.nextInt();
					System.out.println("Jogador " + player.getPlayer2()
							+ ", digite a coluna em que você gostaria de colocar a peça. Mínimo 1, máximo "
							+ (dimension));
					int columnPlayer2 = input.nextInt();
					turnCount += 1;

					// tratar dado: caso o usuário digite 0, colocar 1 por causa do array
					if (linePlayer2 == 0)
						linePlayer2 = 1;
					if (columnPlayer2 == 0)
						columnPlayer2 = 1;

					game.play(linePlayer2 - 1, columnPlayer2 - 1, 'o'); // formatar para começar de 1 e não zero
				}
			}
			game.printBoard();
			
			
			System.out.println("Jogar novamente?");
			String answer = input.nextLine();
			answer = input.nextLine();

			if (answer.equalsIgnoreCase("sim")) {
				replay = true;
			} else if (answer.matches("(?i)(não|nao)")) {
				replay = false;
				System.out.println(player.toString()); // Informar os dados do vencedor se não quiser mais jogar.
				System.out.println("Jogo encerrado.");
			}
		} while (replay == true);

		input.close();
	}	
}
