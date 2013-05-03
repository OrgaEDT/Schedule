package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import amu.licence.edt.model.beans.SessionType;
import amu.licence.edt.model.dao.DAOSessionType;

public class DAOSessionTypeJPA extends DAOGeneriqueJPA<SessionType> implements
        DAOSessionType {

    public DAOSessionTypeJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public SessionType getByLibel(String libel) {
        TypedQuery<SessionType> query = entityManager.createNamedQuery(SessionType.GET_BY_LIBEL, SessionType.class);
        query.setParameter("libel", libel);
        return query.getSingleResult();
    }

}
