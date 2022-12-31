package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.DepartmentDAO;
import model.entities.Department;
import model.entities.Seller;

public class DepartmentDaoJDBC implements DepartmentDAO {

	private Connection connection;
	
	public DepartmentDaoJDBC(Connection connection) {
		this.connection = connection;
	}
	
	
	public void insert(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(
					"INSERT INTO department (Name) "
					+ "VALUES (?);", 
					Statement.RETURN_GENERATED_KEYS); // retornar o id da linha inserida no banco de dados
			
			st.setString(1, department.getName());
			
			int rowsAffected = st.executeUpdate(); // executar sql: inserir linhas no banco
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next() == true) {
					int id = rs.getInt(1);
					department.setId(id);
					System.out.println("Sucesso. ID da linha inserida: " + id);					
				}
				
			} else {
				System.out.println("Falha. Linha nao inserida no banco de dados.");
			}
		} catch (SQLException e){
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	public void update(Department department) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement(
					"UPDATE department "
					+ "SET Name = ?"
					+ "WHERE "
					+ "(Id = ?)");
			st.setString(1, department.getName());
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Sucesso. Linhas atualizadas " + rowsAffected);		
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
	
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "(Id = ?)");
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			
			if (rowsAffected == 0) {
				throw new DbException("Nao existe o id no banco de dados");
			} else {
				System.out.println("Sucesso. Linhas atualizadas " + rowsAffected);		
			}
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
	
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(
					"SELECT department.*, department.Name as DepName "
					+ "FROM department "
					+ "WHERE Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next() == true) {
				Department dp = instantiateDepartment(rs);
								
				return dp;
				
			} else {
				return null;
			}
			
		} catch (SQLException e){
			throw new DbException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(
					"SELECT department.Name AS DepName "
					+ "FROM department "
					+ "ORDER BY Name");
			
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap <Integer, Department>();
			
			while (rs.next() == true) {
				Department dep = map.get(rs.getInt("Id"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("Id"), dep);
				}
				
				Department department = instantiateDepartment(rs);
				list.add(department);
			}
			
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	
	public Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("Id"));
		department.setName(rs.getString("DepName"));
		
		return department;
	}
}
