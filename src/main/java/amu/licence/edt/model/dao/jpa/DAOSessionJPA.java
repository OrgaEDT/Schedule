package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Session;
import amu.licence.edt.model.dao.DAOSession;

public class DAOSessionJPA extends DAOGeneriqueJPA<Session> implements DAOSession {

    public DAOSessionJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
