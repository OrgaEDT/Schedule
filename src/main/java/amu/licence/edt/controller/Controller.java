package amu.licence.edt.controller;

import java.util.Date;
import java.util.List;

import javax.swing.tree.TreeNode;

import amu.licence.edt.model.Model;
import amu.licence.edt.model.Schedule;
import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.Session;
import amu.licence.edt.model.beans.SessionType;
import amu.licence.edt.model.beans.TU;
import amu.licence.edt.model.beans.Teacher;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public boolean validateLoginRequested(String login, String password) {
        return model.tryToConnect(login, password);
    }

    public void disconnectionRequested() {
        model.disconnect();
    }

    public TreeNode scheduleRootNodeRequested() {
        return model.getScheduleRootNode();
    }

    public Date scheduleDateRequested() {
        Schedule s = model.getSchedule();
        return (s != null) ? s.getFirstWeekDay() : null;
    }

    public List<Teacher> teachersListRequested() {
        return model.getTeachersList();
    }

    public void changeNbHoursAdminRequested(Teacher t, int nHours) {
        t.setAdminHours(nHours);
        model.updateTeacher(t);
    }

    public void nextWeekRequested() {
        model.findNextWeek();
    }

    public void prevWeekRequested() {
        model.findPrevWeek();
    }

    public List<Session> scheduleSessionsRequested() {
        return model.getSchedule().getSessions();
    }

    public void newScheduleSessionsRequested(Object o) {
        if (o instanceof Teacher) {
            model.setSessionsOfTeacher((Teacher) o);
        }
        else if (o instanceof Group) {
            model.setSessionsOfGroup((Group) o);
        }
        else if (o instanceof CRoom) {
            model.setSessionsOfCRoom((CRoom) o);
        }
        else if (o instanceof Level) {
            model.setSessionsOfLevel((Level) o);
        }
    }

    public Iterable<Object[]> unplannedSessionsRequested(Level l) {
        return model.getUnplannedSessions(l);
    }

    public List<CRoom> availableCRoomsRequested(SessionType st, Date date, Integer duration) {
        return model.getAvailableCRooms(st, date, duration);
    }

    public List<Teacher> availableTeachersRequested(TU tu, Date date, Integer duration) {
        return model.getAvailableTeachers(tu, date, duration);
    }

}
