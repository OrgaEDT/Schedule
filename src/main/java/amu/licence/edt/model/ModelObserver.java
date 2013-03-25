package amu.licence.edt.model;

import amu.licence.edt.model.beans.Admin;

public interface ModelObserver {

    public void userChanged(Admin user);
    public void scheduleChanged(Schedule schedule);

}
