package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.dao.DAOGroup;

public class DAOGroupJPA extends DAOGeneriqueJPA<Group> implements DAOGroup {

    public DAOGroupJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
