package queryDataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connection.ConnectionFactory;

public class CreateTablePeople {
	
	public static void main(String[] args) throws SQLException {
		
	Connection connection = ConnectionFactory.getConnection();
	
	String sql = "CREATE TABLE IF NOT EXISTS people ("
				+ "id INT AUTO_INCREMENT,"
				+ "name VARCHAR(80) NOT NULL,"
				+ "PRIMARY KEY(id)"
				+ ")";
	
	Statement statement = connection.createStatement();
	statement.execute(sql);
	
	System.out.println("Tabela criada com sucesso");
	
	connection.close();
	}
}
