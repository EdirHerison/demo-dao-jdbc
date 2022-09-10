package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
			 ps = conn.prepareStatement(
					 "INSERT INTO department "
					 + "(Nome) "
					 + "VALUES "
					 + "(?)", 
					 Statement.RETURN_GENERATED_KEYS);
			 
			 ps.setString(1, obj.getName());
			 
			 int rowsAffected = ps.executeUpdate();
			 
			 if(rowsAffected > 0) {
				 rs = ps.getGeneratedKeys();
				  if(rs.next()) {
					  int id = rs.getInt(1);
					  obj.setId(id);	  
				  } 
			 }
			 else {
				 throw new DbException("Erro inesperado !! Nenhuma linha afetada");
			 }
			 
		 }
		 catch(SQLException e){
			 throw new DbException(e.getMessage());
		 }
		 finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"UPDATE department SET Nome=? WHERE id=?"
					);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getLocalizedMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT Id, Nome FROM department WHERE id=?"
					);
			
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Nome"));
				return dep;
			}
			else {
				return null;
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
