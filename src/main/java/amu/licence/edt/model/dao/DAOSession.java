package amu.licence.edt.model.dao;

import java.util.Date;
import java.util.List;

import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.Session;
import amu.licence.edt.model.beans.Teacher;

public interface DAOSession extends DAO<Session> {

    List<Session> findByTeacherPeriod(Teacher t, Date startDate, int days);

    List<Session> executeFindSessionByPeriod(Date startDate, int days);

    List<Session> findByGroupPeriod(Group g, Date startDate, int days);

    List<Session> findByCRoomPeriod(CRoom cr, Date firstWeekDay, int i);

    List<Session> findByLevelPeriod(Level l, Date firstWeekDay, int i);

    /**
     * Find all unplanned session hours,
     * the result's objects are arrays :
     * o[0] : String - libel of the TU
     * o[1] : BigDecimal - unplanned class sessions for the TU o[0]
     * o[2] : BigDecimal - unplanned tutor sessions for the TU o[0]
     * o[3] : BigDecimal - unplanned practical sessions for the TU o[0]
     * o[4] : BigDecimal - unplanned project sessions for the TU o[0]
     */
    Iterable<Object[]> findUnplanned(Level l);

}
