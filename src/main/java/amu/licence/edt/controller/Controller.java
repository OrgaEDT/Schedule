package amu.licence.edt.controller;

import java.util.Date;
import java.util.List;

import javax.swing.tree.TreeNode;

import amu.licence.edt.model.Model;
import amu.licence.edt.model.Schedule;
import amu.licence.edt.model.beans.Session;
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

}
