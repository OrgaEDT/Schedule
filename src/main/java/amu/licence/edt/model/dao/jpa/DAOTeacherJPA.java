package amu.licence.edt.model.dao.jpa;

import javax.persistence.EntityManager;

import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.model.dao.DAOTeacher;

public class DAOTeacherJPA extends DAOGeneriqueJPA<Teacher> implements DAOTeacher {

    public DAOTeacherJPA(EntityManager entityManager) {
        super(entityManager);
    }

}
