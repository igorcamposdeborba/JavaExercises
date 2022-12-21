package model.dao;

import java.util.List;

public interface GenericDAO <T> {
	
	public void insert(T seller);
	
	public void update(T seller);
	
	public void deleteById(Integer id);
	
	public T findById(Integer id);
	
	public List<T> findAll();
}
