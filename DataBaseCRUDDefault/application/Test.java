package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Test {
	public static void main (String [] args) {
		
		 //Department department = new Department(1, "Livros");
		 //Seller seller = new Seller(21, "Igor", "igor@gmail.com", new Date(), 3000.0, department);
		
		 //System.out.println(seller);
		
		
		 SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		 Seller seller = sellerDao.findById(3);
		
		 System.out.println(seller);
	}
}
