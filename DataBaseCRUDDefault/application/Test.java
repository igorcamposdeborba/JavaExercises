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
		
		/* 
		Department department = new Department(1, "Livros");
		 Seller seller = new Seller(21, "Igor", "igor@gmail.com", new Date(), 3000.0, department);
		
		 System.out.println(seller);
		*/
		/*
		 SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		 Seller seller = sellerDao.findById(1);
		
		 System.out.println(seller);
		*/
		
		SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Seller sellerRegister = new Seller(null, "Bruna", "bruna@gmail.com", new Date(sdf.parse("22/04/1985").getTime()), 4300.0, new Department(3, "Books"));
			
			sellerDao.insert(sellerRegister);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
