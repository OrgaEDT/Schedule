package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Promo;
import amu.licence.edt.model.dao.DAOPromo;

public class DAOPromoJPA extends DAOGeneriqueJPA<Promo> implements DAOPromo {

    public DAOPromoJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
