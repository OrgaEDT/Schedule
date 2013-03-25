package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.model.dao.DAOAdmin;

public class DAOAdminJPA extends DAOGeneriqueJPA<Admin> implements DAOAdmin {

    public DAOAdminJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Admin findByLoginPassword(String login, String password) {
        TypedQuery<Admin> q = entityManager.createNamedQuery(Admin.FIND_BY_LOGIN_PASSWORD, Admin.class);
        q.setParameter("login", login);
        q.setParameter("pw", password);
        try {
            return q.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

}
