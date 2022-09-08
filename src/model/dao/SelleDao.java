package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SelleDao {

	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findAll(Integer id);
	List<Seller> findAll();
}
