package amu.licence.edt.model.dao.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import amu.licence.edt.model.beans.TU;
import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.model.dao.DAOTeacher;

public class DAOTeacherJPA extends DAOGeneriqueJPA<Teacher> implements DAOTeacher {

    public DAOTeacherJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Double computeServiceHours(Teacher t) {
        Query q = entityManager.createNamedQuery(Teacher.COMPUTE_SERVICE_HOURS);
        q.setParameter(1, t.getId());
        return ((BigDecimal)q.getSingleResult()).doubleValue();
    }

    @Override
    public List<Teacher> findAvailables(TU tu, Date date, Integer duration) {
        Query q = entityManager.createNamedQuery(Teacher.IS_BUSY);
        q.setParameter(2, date);
        q.setParameter(3, duration);

        List<Teacher> availableTeachers = new ArrayList<Teacher>();
        for (Teacher t : tu.getCompetentTeachers()) {
            if (((BigDecimal)q.setParameter(1, t.getId()).getSingleResult()).intValue() == 0) {
                availableTeachers.add(t);
            }
        }
        return availableTeachers;
    }

}
