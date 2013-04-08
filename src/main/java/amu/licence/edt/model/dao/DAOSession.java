package amu.licence.edt.model.dao;

import java.util.Date;
import java.util.List;

import amu.licence.edt.model.beans.Session;
import amu.licence.edt.model.beans.Teacher;

public interface DAOSession extends DAO<Session> {

    List<Session> findByTeacherPeriod(Teacher t, Date startDate, int days);

    List<Session> executeFindSessionByPeriod(Date startDate, int days);

}
