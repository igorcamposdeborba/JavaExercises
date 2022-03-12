package model;

public class Player {
	private String namePlayer1;
	private String namePlayer2;
	private int pointsPlayer1 = 0;
	private int pointsPlayer2 = 0;
	
	public Player(String namePlayer1, String namePlayer2) {
		this.namePlayer1 = namePlayer1;
		this.namePlayer2 = namePlayer2;
	}
	
	public String getPlayer1 () {
		return namePlayer1;
	}
	public String getPlayer2 () {
		return namePlayer2;
	}
	public int getPointsPlayer1() {
		return pointsPlayer1;
	}
	public int getPointsPlayer2() {
		return pointsPlayer2;
	}
	
	public void setPlayer1(String namePlayer1) {
		this.namePlayer1 = namePlayer1;
	}
	public void setPlayer2(String namePlayer2) {
		this.namePlayer2 = namePlayer2;
	}
	public void setPointsPlayer1(int pointsPlayer1) {
		this.pointsPlayer1 = pointsPlayer1;
	}
	public void setPointsPlayer2(int pointsPlayer2) {
		this.pointsPlayer2 = pointsPlayer2;
	}
	
	
	public String toString() {
		return "O jogador " + namePlayer1 + " tem pontuação " + pointsPlayer1 + "." 
		   + "\nO jogador " + namePlayer2 + " tem pontuação " + pointsPlayer2 + "."; 
	}
}
