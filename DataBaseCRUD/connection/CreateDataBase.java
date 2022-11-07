package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDataBase {
	
	public static void main(String[] args) throws SQLException {
	
	Connection connection = ConnectionFactory.getConnection(); // classe que cria conexão
		
	Statement statement = connection.createStatement();
	statement.execute("CREATE DATABASE IF NOT EXISTS curso_java2");
	
	
	System.out.println("Banco de dados criado com sucesso");
	connection.close();	
	
	}
	
}
