package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Principal {
	public static void main (String [] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DB.getConnection();
			
			preparedStatement = connection.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS
					);
			preparedStatement.setString(1, "Igor Borba");
			preparedStatement.setString(2, "igorborba@gmail.com");
			preparedStatement.setDate(3, new java.sql.Date(sdf.parse("01/06/1994").getTime()));
			preparedStatement.setDouble(4, 3000.00);
			preparedStatement.setInt(5, 4);
			
			
			int rowAffected = preparedStatement.executeUpdate();
			if (rowAffected > 0) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				while (resultSet.next() == true) {
					int id = resultSet.getInt(1);
					System.out.println("Feito. Id: " + id);
				}
			} else {
				System.out.println("Nao houve alteracoes");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		} catch (ParseException e) {
			e.printStackTrace();
			
		} finally {
			DB.closeStatement(preparedStatement);
			DB.closeConnection();
		}
		
	}
}
