package composition.challenge;

import java.util.Arrays;
import java.util.List;

public class Client {
	public int id;
	private String name;
	private String cpf;

	// Composition
	List<Purchase> purchaseList;
	
	public Client(int id, String name, String cpf) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	}
	
	// Access methods
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCpf() {
		return cpf;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	// Composition methods
	public List<Purchase> getPurchaseList(){
		return purchaseList;
	}
	
	public Purchase getPurchaseById(int id) throws NullPointerException {
		Purchase varPurchase = null;
		
		for(Purchase i : purchaseList) {
			if(i.getId() == id) {
				varPurchase = i;
			} else {
				throw new NullPointerException("Client doesn't has product");
			}
		}
		return varPurchase;
	}
	
	public void setPurchase(Purchase purchase) {
			purchaseList.add(purchase);
	}
	
	public void removePurchaseById(int id) {
		for(Purchase i : purchaseList) {
			
			if (i.getId() == id) {
				i.removeItemsById(id);
			}
		}
	}
	
	// Logic methods
	public double getTotalPrice() {
		double counterTotalPrice = 0.0;
		
		for(Purchase i : purchaseList) {
			counterTotalPrice += i.getTotalPrice();
		}
		return counterTotalPrice;
	}
	
	// Default methods
	@Override
	public String toString() {
		return id + ", " + name + ", " + cpf; 
	}
}
