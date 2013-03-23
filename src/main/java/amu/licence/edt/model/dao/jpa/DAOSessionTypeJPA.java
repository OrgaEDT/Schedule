package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.SessionType;
import amu.licence.edt.model.dao.DAOSessionType;

public class DAOSessionTypeJPA extends DAOGeneriqueJPA<SessionType> implements
        DAOSessionType {

    public DAOSessionTypeJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
