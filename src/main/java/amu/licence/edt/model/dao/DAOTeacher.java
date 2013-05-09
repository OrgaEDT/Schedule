package amu.licence.edt.model.dao;

import java.util.Date;
import java.util.List;

import amu.licence.edt.model.beans.TU;
import amu.licence.edt.model.beans.Teacher;

public interface DAOTeacher extends DAO<Teacher> {

    public Double computeServiceHours(Teacher t);

    public List<Teacher> findAvailables(TU tu, Date date, Integer duration);

}
