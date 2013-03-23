package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Unavailability;
import amu.licence.edt.model.dao.DAOUnavailability;

public class DAOUnavailabilityJPA extends DAOGeneriqueJPA<Unavailability> implements
        DAOUnavailability {

    public DAOUnavailabilityJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
