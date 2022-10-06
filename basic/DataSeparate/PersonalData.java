package vectors;

public class PersonalData {
	private double height;
	private char genre;
	
	public PersonalData(double height, char genre) {
		this.height = height;
		
		if (genre == 'M' || genre == 'F' || genre == 'm' || genre == 'f') {
			genre = Character.toUpperCase(genre); // char to uppercase because it's default in methods
			this.genre = genre;
		} else {
			System.err.println("Genero invalido: digite M para masculino ou F para feminino");
		}
	}
	
	public double getHeight() {
		return height;
	}
	public char getGenre() {
		return genre;
	}
	
}
