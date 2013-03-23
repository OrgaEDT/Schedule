package amu.licence.edt.model.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import amu.licence.edt.model.dao.DAO;

public class DAOGeneriqueJPA<T extends Serializable> implements DAO<T> {

    protected EntityManager entityManager;

    private Class<T> entityClass;
    private String entityName;

    @SuppressWarnings("unchecked")
    public DAOGeneriqueJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityClass = (Class<T>) ((ParameterizedType) getClass().
                                                    getGenericSuperclass()).
                                                    getActualTypeArguments()[0];
        this.entityName = entityClass.getSimpleName();
    }

    @Override
    public T create(T obj) {
        if (obj == null) return null;
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
        return obj;
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery(
                "SELECT t FROM " + entityName + " t", entityClass).
                                                            getResultList();
    }

    @Override
    public T getById(int id) {
        entityManager.find(entityClass, id);
        return null;
    }

    @Override
    public void update(T obj) {
        if (obj == null) return;
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T obj) {
        if (obj == null) return;
        entityManager.getTransaction().begin();
        entityManager.remove(obj);
        entityManager.getTransaction().commit();

    }

}
