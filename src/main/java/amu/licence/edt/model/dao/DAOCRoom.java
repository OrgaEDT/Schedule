package amu.licence.edt.model.dao;

import java.util.Date;
import java.util.List;

import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.SessionType;

public interface DAOCRoom extends DAO<CRoom> {

    public List<CRoom> findAvailables(SessionType st, Date date, Integer duration);

}
