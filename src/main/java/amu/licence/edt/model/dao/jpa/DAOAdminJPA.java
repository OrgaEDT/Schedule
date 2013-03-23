package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.model.dao.DAOAdmin;

public class DAOAdminJPA extends DAOGeneriqueJPA<Admin> implements DAOAdmin {

    public DAOAdminJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
