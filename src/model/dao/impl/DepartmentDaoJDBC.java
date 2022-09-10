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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findAll(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
