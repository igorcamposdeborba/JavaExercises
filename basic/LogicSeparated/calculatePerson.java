package vectors;

import java.util.ArrayList;

public class calculatePerson { // classe para a logica de cálculo dos dados
	// private HeightPerson person; // composição para pegar os dados da classe que criou o objeto
	private ArrayList<HeightPerson> peopleArray = new ArrayList<HeightPerson>(); // guardar num array todos os objetos	
	private double averageHeight;
	private int averageAgeSixteen;
	
	public calculatePerson(HeightPerson [] peopleArray) { // receber array de objetos preenchido
		for (int i=0; i < peopleArray.length; i++) {
			this.peopleArray.add(peopleArray[i]);
		}
	}
	
	// Cálculos
	public double averageHeight() {
		double counterHeight = 0;
		for (int i=0; i < peopleArray.size(); i++) {
			counterHeight += peopleArray.get(i).getHeight(); // pegar idade de cada item do array de objetos
		}
		return this.averageHeight = counterHeight / peopleArray.size();
	}
	
	public double averageAgeSixteen() {
		double counterAge = 0;
		for (int i=0; i < peopleArray.size(); i++) {
			if (peopleArray.get(i).getAge() < 16) { // fazer média se tem idade menor que 16 anos
				counterAge ++;
			}
		}
		return this.averageHeight = (counterAge / peopleArray.size()) * 100;
	}
	
	
	public ArrayList<String> getNameLessThanAgeSixteen() {
		ArrayList <String> names = new ArrayList<String>();
		
		for (int i=0; i < peopleArray.size(); i++) {
			if (peopleArray.get(i).getAge() < 16) { // fazer média se tem idade menor que 16 anos
				names.add(peopleArray.get(i).getName());
			}
		}
		return names;
	}
}
