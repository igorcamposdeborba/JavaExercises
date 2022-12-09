package model.services;

import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class ProductService {

	public ProductService() {}
	
	
													// A função criteria é uma função dentro de um método. Criteria é programação funcional
													// facilita porque recebo o critério na class Principal
	public double filteredSum(List<Product> product, Predicate <Product> criteria) { 
		double sum = 0.0;
		for (Product i : product) {
			
			if (criteria.test(i) == true) {
				sum += i.getPrice();
			}
		}
		
		return sum;
	}
}
