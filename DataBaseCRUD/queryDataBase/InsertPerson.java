package queryDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionFactory;

public class InsertPerson {
	public static void main(String[] args) throws SQLException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Informe o nome");
		String name = input.nextLine();
		
		Connection connection = ConnectionFactory.getConnection();
		
		String sql = "INSERT INTO people (name) VALUES (?);";
		PreparedStatement statement = connection.prepareStatement(sql); // ! PreparedStatement protege contra SQL injection
		statement.setString(1, name); // converter para string o primeiro parâmetro protege contra SQL injection
									  // 1 significa que peguei o 1° parametro.
		
		statement.execute();
		System.out.println("Pessoa incluida com sucesso");
		
		input.close();
	}
}
