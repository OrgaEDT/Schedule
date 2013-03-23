package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Rank;
import amu.licence.edt.model.dao.DAORank;

public class DAORankJPA extends DAOGeneriqueJPA<Rank> implements DAORank {

    public DAORankJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
