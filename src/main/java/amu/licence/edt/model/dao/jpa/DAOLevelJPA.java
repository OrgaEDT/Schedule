package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.dao.DAOLevel;

public class DAOLevelJPA extends DAOGeneriqueJPA<Level> implements DAOLevel {

    public DAOLevelJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
