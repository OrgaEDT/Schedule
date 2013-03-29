package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.model.dao.DAOTeacher;

public class DAOTeacherJPA extends DAOGeneriqueJPA<Teacher> implements DAOTeacher {

    public DAOTeacherJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Long computeServiceHours(Teacher t) {

        TypedQuery<Long> q = entityManager.createNamedQuery(Teacher.COMPUTE_SERVICE_HOURS, Long.class);
        q.setParameter("t", t);
        Long serviceHours = q.getSingleResult();

        return (serviceHours != null) ? t.getAdminHours() + serviceHours
                                      : t.getAdminHours();
    }

}
