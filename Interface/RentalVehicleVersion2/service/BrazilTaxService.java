package service;

public class BrazilTaxService implements TaxService {
	
	@Override
	public Double tax(Double amount) { // imposto baseado no preço do produto
		if (amount > 100.00) {
			return amount * 0.15;
		}
		return amount * 0.20;
		
	}
}
