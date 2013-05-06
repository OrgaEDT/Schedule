package amu.licence.edt.model.dao;

import java.util.Date;

import amu.licence.edt.model.beans.Group;

public interface DAOGroup extends DAO<Group> {

    public boolean isAvailable(Group group, Date date, Integer duration);

}
