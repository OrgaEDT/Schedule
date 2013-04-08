package amu.licence.edt.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import amu.licence.edt.model.beans.Session;

public class Schedule {

    private Date firstWeekDay;
    private List<Session> sessions;

    public Schedule() {
        this.firstWeekDay = findFirstWeekDay();
        this.sessions = new ArrayList<Session>();
    }

    private Date findFirstWeekDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 2 - c.get(Calendar.DAY_OF_WEEK));
        return c.getTime();
    }

    public Date getFirstWeekDay() {
        return firstWeekDay;
    }

    public void setFirstWeekDay(Date firstWeekDay) {
        this.firstWeekDay = firstWeekDay;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Date computeNextWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(firstWeekDay);
        c.add(Calendar.DAY_OF_MONTH, 7);
        return c.getTime();
    }

    public Date computePrevWeek() {
        Calendar c = Calendar.getInstance();
        c.setTime(firstWeekDay);
        c.add(Calendar.DAY_OF_MONTH, -7);
        return c.getTime();
    }

}
