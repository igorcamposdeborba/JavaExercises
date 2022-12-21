package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection connection = null;
	
	// salvar dados de login do banco de dados
	private static Properties loadProperties () {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
			
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	// Criar conexão com o banco de dados
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				connection = DriverManager.getConnection(url, props);
			
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
		return connection;
	}
	
	
	// fechar conexão com o banco de dados
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// fechar Statement de consulta SQL
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	// fechar ResultSet de retorno do banco
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
}
