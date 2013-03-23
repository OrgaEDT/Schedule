package amu.licence.edt.model.dao;

import java.io.Serializable;
import java.util.List;

/*
 * CRUD
 */
public interface DAO<T extends Serializable> {

	public T create(T obj);

	public List<T> findAll();

	public T getById(int id);

	public void update(T obj);

	public void delete(T obj);

}
