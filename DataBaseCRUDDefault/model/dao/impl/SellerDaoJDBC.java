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
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDAO{

	private Connection connection;
	
	public SellerDaoJDBC(Connection connection) {
		this.connection = connection;
	} 
	
	
	@Override
	public void insert(Seller seller)  {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(
					"INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES (?, ?, ?, ?, ?);", 
					Statement.RETURN_GENERATED_KEYS); // retornar o id da linha inserida no banco de dados
			
			st.setString(1, seller.getName());
			st.setString(2, seller.getEmail());
			st.setDate(3, new Date(seller.getBirthDate().getTime()));
			st.setDouble(4, seller.getBaseSalary());
			st.setInt(5, seller.getDepartment().getId());
			
			int rowsAffected = st.executeUpdate(); // executar sql: inserir linhas no banco
			if (rowsAffected > 0) {
				rs = st.getGeneratedKeys();
				while (rs.next() == true) {
					int id = rs.getInt(1);
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

	@Override
	public void update(Seller seller) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			st.setDouble(1, seller.getSalary());
			st.setInt(2, seller.getDepartment().getId());
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Sucesso. Linhas atualizadas " + rowsAffected);		
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		
		try {
			st = connection.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "(Id = ?)");
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Sucesso. Linhas atualizadas " + rowsAffected);		
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
			
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next() == true) {
				Department dp = instantiateDepartment(rs);
				Seller seller = instantiateSeller(rs, dp);
				
				return seller;
				
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

	@Override
	public List<Seller> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(
					"SELECT seller.*, department.Name AS DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "ORDER BY Name");
			
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap <Integer, Department>();
			
			while (rs.next() == true) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);
				list.add(seller);
			}
			
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = connection.prepareStatement(
					"SELECT seller.*, department.Name AS DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			st.setInt(1, department.getId());
			
			rs = st.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap <Integer, Department>();
			
			while (rs.next() == true) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Seller seller = instantiateSeller(rs, dep);
				list.add(seller);
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
		department.setId(rs.getInt("DepartmentId"));
		department.setName(rs.getString("DepName"));
		
		return department;
	}
	public Seller instantiateSeller(ResultSet rs, Department department) throws SQLException {
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setDepartment(department);
		
		return seller;
	}
	

}
