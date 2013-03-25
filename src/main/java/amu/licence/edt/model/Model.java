package amu.licence.edt.model;

import java.util.ArrayList;
import java.util.List;

import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.model.dao.DAOFactory;
import amu.licence.edt.model.dao.DAOFactoryManager;

public class Model {

    private Admin user;
    private Schedule schedule;

    private DAOFactory daoFactory;

    private List<ModelObserver> observers;

    public Model() {
        super();
        this.daoFactory = DAOFactoryManager.createDAOFactory();
        this.observers = new ArrayList<ModelObserver>();
    }

    public void fireUserChanged() {
        for (ModelObserver o : observers) {
            o.userChanged(user);
        }
    }

    public void fireScheduleChanged() {
        for (ModelObserver o : observers) {
            o.scheduleChanged(schedule);
        }
    }

    public Admin getUser() {
        return user;
    }

    public void setUser(Admin user) {
        this.user = user;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public boolean addObserver(ModelObserver o) {
        return this.observers.add(o);
    }

    public boolean removeObserver(ModelObserver o) {
        return this.observers.remove(o);
    }

}
