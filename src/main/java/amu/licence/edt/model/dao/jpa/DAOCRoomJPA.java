package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.dao.DAOCRoom;

public class DAOCRoomJPA extends DAOGeneriqueJPA<CRoom> implements DAOCRoom {

    public DAOCRoomJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
