package amu.licence.edt.model;

import java.util.Calendar;
import java.util.Date;

public class Schedule {

    private Date firstWeekDay;

    public Schedule() {
        this.firstWeekDay = findFirstWeekDay();
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
