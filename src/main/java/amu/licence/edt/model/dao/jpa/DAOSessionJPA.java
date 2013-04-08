package amu.licence.edt.model.dao.jpa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
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
        return executeFindSessionByPeriod(startDate, days);
    }

    @Override
    public List<Session> findByGroupPeriod(Group g, Date startDate, int days) {
        query = entityManager.createNamedQuery(Session.FIND_BY_GROUP, Session.class);
        query.setParameter("group", g);
        return executeFindSessionByPeriod(startDate, days);
    }

    @Override
    public List<Session> findByCRoomPeriod(CRoom cr, Date startDate, int days) {
        query = entityManager.createNamedQuery(Session.FIND_BY_CROOM, Session.class);
        query.setParameter("cRoom", cr);
        return executeFindSessionByPeriod(startDate, days);
    }

    @Override
    public List<Session> findByLevelPeriod(Level l, Date startDate, int days) {
        return new ArrayList<Session>();
//        query = entityManager.createNamedQuery(Session.FIND_BY_LEVEL, Session.class);
//        query.setParameter("level", l);
//        return executeFindSessionByPeriod(startDate, days);
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
