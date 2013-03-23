package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.CRoomType;
import amu.licence.edt.model.dao.DAOCRoomType;

public class DAOCRoomTypeJPA extends DAOGeneriqueJPA<CRoomType> implements DAOCRoomType {

    public DAOCRoomTypeJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
