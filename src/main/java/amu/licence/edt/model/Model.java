package amu.licence.edt.model;

import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.model.dao.DAOFactory;
import amu.licence.edt.model.dao.DAOFactoryManager;

public class Model {

    private Admin user;
    private Schedule schedule;

    private DAOFactory daoFactory;

    public Model() {
        super();
        this.daoFactory = DAOFactoryManager.createDAOFactory();
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

}
