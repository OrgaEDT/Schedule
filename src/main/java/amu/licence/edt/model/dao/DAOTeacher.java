package amu.licence.edt.model.dao;

import amu.licence.edt.model.beans.Teacher;

public interface DAOTeacher extends DAO<Teacher> {

    public Long computeServiceHours(Teacher t);

}
