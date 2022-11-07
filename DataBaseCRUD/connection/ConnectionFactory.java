package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() {
		
		try {
			final String url = "jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSL=true";
			final String user = "root";
			final String password = "123456";

			return DriverManager.getConnection(url, user, password);
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
