package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.TU;
import amu.licence.edt.model.dao.DAOTU;

public class DAOTUJPA extends DAOGeneriqueJPA<TU> implements DAOTU {

    public DAOTUJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
