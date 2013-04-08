package amu.licence.edt.model.dao.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import amu.licence.edt.model.beans.Session;
import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.model.dao.DAOSession;

public class DAOSessionJPA extends DAOGeneriqueJPA<Session> implements DAOSession {

    private TypedQuery<Session> query;

    public DAOSessionJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<Session> findByTeacherPeriod(Teacher t, Date startDate, int days) {
        query = entityManager.createNamedQuery(Session.FIND_BY_TEACHER, Session.class);
        query.setParameter("teacher", t);
        query.setParameter("startDate", startDate);
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DAY_OF_MONTH, days);
        query.setParameter("endDate", c.getTime());
        return query.getResultList();
    }

    @Override
    public List<Session> executeFindSessionByPeriod(Date startDate, int days) {
        if (query == null) return null;
        query.setParameter("startDate", startDate);
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DAY_OF_MONTH, days);
        query.setParameter("endDate", c.getTime());
        return query.getResultList();
    }

}
