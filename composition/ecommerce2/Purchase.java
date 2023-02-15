package composition.challenge;

import java.util.Arrays;
import java.util.List;

public class Purchase {
	
	private int id;
	
	// Composition
	private List<Item> itemList;
	
	public Purchase() {}
	
	public Purchase(int id, List<Item> itemList) {
		this.id = id;
		this.itemList = itemList;
	}

	// Access methods
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// Composition methods
	public List<Item> getItems(){
		return itemList;
	}
	public void setItems(Item item) {
		itemList.add(item);
	}
	
	public void removeItemsById(int id) {
		for(int i=0; i<itemList.size(); i++) {
			
			if (itemList.get(i).getId() == id) {
				itemList.remove(i);
			}
		}
	}
	
	// Logic methods
	public double getTotalPrice() {
		double counterTotalPrice = 0.0;
		for (Item i: itemList) {
			counterTotalPrice = i.getProduct().getPrice();
		}
		return counterTotalPrice;
	}
	
	
	// Default methods
	@Override
	public String toString() {
		return id + ", " + Arrays.toString(itemList.toArray()); 
	}
}
