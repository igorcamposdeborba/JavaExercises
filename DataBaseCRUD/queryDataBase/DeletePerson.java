package queryDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import connection.ConnectionFactory;

public class DeletePerson {
	public static void main (String [] args) throws SQLException {
		
		Scanner input = new Scanner(System.in);
	
		Connection connection = ConnectionFactory.getConnection();
		
		String sqlDelete = "DELETE FROM people WHERE id=?";
		
		System.out.println("Informe o codigo para deletar a linha");
		int idDelete = input.nextInt();
		
		PreparedStatement statement = connection.prepareStatement(sqlDelete);
		statement.setInt(1, idDelete);
	
		if (statement.executeUpdate() > 0) {
			System.out.println(statement.executeUpdate() + " pessoa excluida com sucesso");
		} else {
			System.out.println("Pessoa NAO excluida");
		}
		
		connection.close();
		input.close();
	}
}
