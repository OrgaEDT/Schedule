package amu.licence.edt.model.dao;

import amu.licence.edt.model.dao.jpa.DAOFactoryJPA;

public class DAOFactoryManager {

    public static DAOFactory getDAOFactory() {
        return DAOFactoryJPA.getInstance();
    }

}
