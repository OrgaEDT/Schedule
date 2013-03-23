package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import amu.licence.edt.model.dao.DAOAdmin;
import amu.licence.edt.model.dao.DAOCRoom;
import amu.licence.edt.model.dao.DAOCRoomType;
import amu.licence.edt.model.dao.DAOFactory;
import amu.licence.edt.model.dao.DAOGroup;
import amu.licence.edt.model.dao.DAOLevel;
import amu.licence.edt.model.dao.DAOPromo;
import amu.licence.edt.model.dao.DAORank;
import amu.licence.edt.model.dao.DAOSession;
import amu.licence.edt.model.dao.DAOSessionType;
import amu.licence.edt.model.dao.DAOTU;
import amu.licence.edt.model.dao.DAOTeacher;
import amu.licence.edt.model.dao.DAOUnavailability;

public class DAOFactoryJPA implements DAOFactory {

    private static DAOFactoryJPA instance = null;

    public static DAOFactoryJPA getInstance() {
        if (instance == null)
            instance = new DAOFactoryJPA();
        return instance;
    }

    private final EntityManagerFactory entityManagerFactory =
                        Persistence.createEntityManagerFactory("schedulePU");
    private EntityManager entityManager;

    private DAOAdmin          daoAdmin;
    private DAOCRoom          daoCRoom;
    private DAOCRoomType      daoCRoomType;
    private DAOGroup          daoGroup;
    private DAOLevel          daoLevel;
    private DAOPromo          daoPromo;
    private DAORank           daoRank;
    private DAOSession        daoSession;
    private DAOSessionType    daoSessionType;
    private DAOTeacher        daoTeacher;
    private DAOTU             daoTU;
    private DAOUnavailability daoUnavailability;

    public DAOFactoryJPA() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    protected void finalize() throws Throwable { closeEm(); };

    public void closeEm() {
        entityManagerFactory.close();
        entityManager.close();
    }

    @Override
    public DAOAdmin getDAOAdmin() {
        if (daoAdmin == null)
            daoAdmin = new DAOAdminJPA(entityManager);
        return daoAdmin;
    }

    @Override
    public DAOCRoom getDAOCRoom() {
        if (daoCRoom == null)
            daoCRoom = new DAOCRoomJPA(entityManager);
        return daoCRoom;
    }

    @Override
    public DAOCRoomType getDAOCRoomType() {
        if (daoCRoomType == null)
            daoCRoomType = new DAOCRoomTypeJPA(entityManager);
        return daoCRoomType;
    }

    @Override
    public DAOGroup getDAOGroup() {
        if (daoGroup == null)
            daoGroup = new DAOGroupJPA(entityManager);
        return daoGroup;
    }

    @Override
    public DAOLevel getDAOLevel() {
        if (daoLevel == null)
            daoLevel = new DAOLevelJPA(entityManager);
        return daoLevel;
    }

    @Override
    public DAOPromo getDAOPromo() {
        if (daoPromo == null)
            daoPromo = new DAOPromoJPA(entityManager);
        return daoPromo;
    }

    @Override
    public DAORank getDAORank() {
        if (daoRank == null)
            daoRank = new DAORankJPA(entityManager);
        return daoRank;
    }

    @Override
    public DAOSession getDAOSession() {
        if (daoSession == null)
            daoSession = new DAOSessionJPA(entityManager);
        return daoSession;
    }

    @Override
    public DAOSessionType getDAOSessionType() {
        if (daoSessionType == null)
            daoSessionType = new DAOSessionTypeJPA(entityManager);
        return daoSessionType;
    }

    @Override
    public DAOTeacher getDAOTeacher() {
        if (daoTeacher == null)
            daoTeacher = new DAOTeacherJPA(entityManager);
        return daoTeacher;
    }

    @Override
    public DAOTU getDAOTU() {
        if (daoTU == null)
            daoTU = new DAOTUJPA(entityManager);
        return daoTU;
    }

    @Override
    public DAOUnavailability getDAOUnavailability() {
        if (daoUnavailability == null)
            daoUnavailability = new DAOUnavailabilityJPA(entityManager);
        return daoUnavailability;
    }

}
