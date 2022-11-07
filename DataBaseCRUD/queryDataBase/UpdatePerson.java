package queryDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import connection.ConnectionFactory;
import entities.Person;

public class UpdatePerson {
	public static void main (String [] args) throws SQLException {
		
		Scanner input = new Scanner(System.in);

		String sqlSearchName = "SELECT * FROM people WHERE name LIKE ?;";
		String sqlReplace = "UPDATE people SET name = ? WHERE id= ?";
		
		System.out.println("Digite um nome para buscar");
		String searchName = input.nextLine();
		
		// 1) Buscar nomes
		Connection connection = ConnectionFactory.getConnection(); // iniciar conexão com banco de dados
		PreparedStatement statement = connection.prepareStatement(sqlSearchName); // converter consulta SQL num objeto
		statement.setString(1, "%" + searchName + "%"); // inserir na consulta SQL no campo ? o nome
		
		ResultSet resultSearch = statement.executeQuery(); // executar SQL
		
		// imprimir pessoas do banco de dados
		printPerson(resultSearch);		
		
		
		// 2) Substituir nome			
		System.out.println("\nDigite o codigo da pessoa que voce ira alterar o nome");
		String idPerson = input.nextLine();
		System.out.println("Digite o novo nome");
		String nameReplace = input.nextLine();
		
		statement.close(); // encerrar objeto string com consulta sql
			
		statement = connection.prepareStatement(sqlReplace); // iniciar objeto string com consulta sql
		statement.setString(1, nameReplace);
		statement.setString(2, idPerson);
		
		statement.execute(); // executar SQL
		
		
		// 3) Mostrar em tela todos os nomes
		resultSearch = statement.executeQuery("SELECT * FROM people;");
		
		// imprimir pessoas do banco de dados
		printPerson(resultSearch);

		statement.close();
		connection.close();
		input.close();
	}
	
	public static void printPerson(ResultSet resultSearch) throws SQLException {
		ArrayList<Person> people = new ArrayList<Person>();
		
		// adicionar no array cada objeto da linha pessoa
		while (resultSearch.next()) {
			int id = resultSearch.getInt("id");
			String name = resultSearch.getString("name");
			people.add(new Person(id, name));
		}
		// imprimir na tela o resultado
		for (Person i : people) {
			System.out.println(i.getId() + " - " + i.getName());
		}
	}
}
