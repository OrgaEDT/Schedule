package amu.licence.edt.model.dao.jpa;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.dao.DAOGroup;

public class DAOGroupJPA extends DAOGeneriqueJPA<Group> implements DAOGroup {

    public DAOGroupJPA(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean isAvailable(Group group, Date date, Integer duration) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
            c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return false;
        } else {
            Query q = entityManager.createNativeQuery("SELECT group_available(?1, ?2, ?3) FROM dual");
            q.setParameter(1, (group.getId() != 0) ? group.getId() : null);
            q.setParameter(2, date);
            q.setParameter(3, duration);
            return ((BigDecimal)q.getSingleResult()).intValue() == 1;
        }
    }

}
