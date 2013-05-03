package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import amu.licence.edt.model.beans.TU;
import amu.licence.edt.model.dao.DAOTU;

public class DAOTUJPA extends DAOGeneriqueJPA<TU> implements DAOTU {

    public DAOTUJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public TU getByLibel(String libel) {
        TypedQuery<TU> query = entityManager.createNamedQuery(TU.GET_BY_LIBEL, TU.class);
        query.setParameter("libel", libel);
        return query.getSingleResult();
    }

}
