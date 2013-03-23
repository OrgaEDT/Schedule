package amu.licence.edt.model.dao;

public interface DAOFactory {

    public DAOAdmin          getDAOAdmin();
    public DAOSession        getDAOSession();
    public DAOUnavailability getDAOUnavailability();
    public DAOCRoom          getDAOCRoom();
    public DAOLevel          getDAOLevel();
    public DAOSessionType    getDAOSessionType();
    public DAOCRoomType      getDAOCRoomType();
    public DAOPromo          getDAOPromo();
    public DAOTeacher        getDAOTeacher();
    public DAOGroup          getDAOGroup();
    public DAORank           getDAORank();
    public DAOTU             getDAOTU();

}