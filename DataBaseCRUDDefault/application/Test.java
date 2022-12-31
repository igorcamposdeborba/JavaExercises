package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;

public class Test {
	public static void main (String [] args) {
		
		/* Instanciar objetos
		Department department = new Department(1, "Livros");
		 Seller seller = new Seller(21, "Igor", "igor@gmail.com", new Date(), 3000.0, department);
		
		 System.out.println(seller);
		*/
		
		// Procurar por ID no banco de dados
		/*
		SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(5);
		
		System.out.println(seller);
		*/
		
		// Inserir objeto no banco
		/*
		SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Seller sellerRegister = new Seller(null, "Luana", "Luana@hotmail.com", new Date(sdf.parse("25/04/1992").getTime()), 2300.0, new Department(3, "Fashion"));
			
			sellerDao.insert(sellerRegister);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		*/
		
		// Atualizar objeto no banco
		/*
		SellerDAO sellerDao = DaoFactory.createSellerDao(); // criar conexão
		
		Seller sellerUpdate = new Seller(); // objeto temporario para atualizar o salario de todos os colaboradores de um setor
		sellerUpdate.setBaseSalary(0.0); // obrigatório passar zero por ser um objeto temporário
		sellerUpdate.incrementSalary(200);
		sellerUpdate.setDepartment(new Department(2, "Electronics"));
		
		sellerDao.update(sellerUpdate);
		*/
		
		// Deletar objeto no banco
		/*
		SellerDAO sellerDao = DaoFactory.createSellerDao(); // criar conexão
		
		Integer departmentIdDelete = 20; // variavel para deletar um departament pelo id
		
		sellerDao.deleteById(departmentIdDelete);
		*/
		
		// Transação com rollback e commit
		/*Connection cn = null; // criar conexão
		Statement st = null;
		
		try {
			cn = DB.getConnection();
			cn.setAutoCommit(false); // false = não executar as queries antes do programa terminar (deve ter .commit())
			
			st = cn.createStatement();
			
			int row1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
			int row2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			cn.commit(); // comitar alterações: confirma que execução terminou
			
			System.out.println("row1 " + row1);
			System.out.println("row2 " + row2);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		// Buscar por id do vendedor
		/*
		SellerDAO sellerDao = DaoFactory.createSellerDao(); // criar conexão
		
		Seller seller = sellerDao.findById(2);
		
		System.out.println(seller);
		*/
		
		// Buscar por id do departamento
		/*SellerDAO sellerDao = DaoFactory.createSellerDao(); // criar conexão
		
		Department department = new Department(1, null);
		List<Seller> sellerList = sellerDao.findByDepartment(department);
		
		for (Seller i : sellerList) {
			System.out.println(i);
		}
		*/
		
		// Buscar todos os vendedores
		/*SellerDAO sellerDao = DaoFactory.createSellerDao(); // criar conexão
		
		List<Seller> sellerList = sellerDao.findAll();
		
		for (Seller i : sellerList) {
			System.out.println(i);
		}*/
		
		// Buscar por ID E atualizar nome
		/*SellerDAO sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = new Seller();
		
		seller = sellerDao.findById(1); // buscar por id
		
		seller.setName("Igor Campos de Borba"); // atualizar nome no objeto
		
		sellerDao.update(seller); // update no banco de dados por meio do padrão de projetos DAO
		*/
	}
}
