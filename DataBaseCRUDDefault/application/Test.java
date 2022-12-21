package application;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Test {
	public static void main (String [] args) {
		
		/* Instanciar objetos
		Department department = new Department(1, "Livros");
		 Seller seller = new Seller(21, "Igor", "igor@gmail.com", new Date(), 3000.0, department);
		
		 System.out.println(seller);
		*/
		
		/* Procurar por ID no banco de dados
		 SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		 Seller seller = sellerDao.findById(7);
		
		 System.out.println(seller);
		*/
		
		// Inserir objeto no banco
		SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Seller sellerRegister = new Seller(null, "Jonas", "jonas@gmail.com", new Date(sdf.parse("15/06/1995").getTime()), 3000.0, new Department(2, "Electronics"));
			
			sellerDao.insert(sellerRegister);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
