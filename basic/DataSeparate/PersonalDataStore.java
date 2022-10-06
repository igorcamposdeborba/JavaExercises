package vectors;

import java.util.ArrayList;

public class PersonalDataStore {

	private ArrayList <PersonalData> personArray = new ArrayList<PersonalData>(); // save each person in dynamic array
	
	public PersonalDataStore(PersonalData [] people ) {
		for (int i=0; i<people.length; i++) {
			this.personArray.add(people[i]);
		}
	}
	
	public double greathestHeight() {
		double tempHeight = 0.0;
		
		for (int i=0; i<personArray.size(); i++) {
			if (personArray.get(i).getHeight() > tempHeight) {
				tempHeight = personArray.get(i).getHeight();
			}
		}
		return tempHeight;
	}
	
	public double lowerHeight() {
		double tempHeight = 9999999.99;
		
		for (int i=0; i<personArray.size(); i++) {
			if (personArray.get(i).getHeight() < tempHeight) {
				tempHeight = personArray.get(i).getHeight();
			}
		}
		return tempHeight;
	}
	
	public double averageHeightWomans() {
		double tempHeight = 0.0;
		int quantityWomans = 0;
		
		for (int i=0; i<personArray.size(); i++) {
			if (personArray.get(i).getGenre() == 'F') {
				tempHeight += personArray.get(i).getHeight();
				quantityWomans = quantityWomans + 1;
			}
		}
		double result = tempHeight / quantityWomans;
		
		return result;
	}
	
	public double quantityMen() {
		int tempGenre = 0;
		
		for (int i=0; i<personArray.size(); i++) {
			if (personArray.get(i).getGenre() == 'M') {
				tempGenre = tempGenre + 1;
			}
		}
		return tempGenre;
	}
	
}
