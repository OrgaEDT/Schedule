package amu.licence.edt.presenter;

import amu.licence.edt.controller.Controller;
import amu.licence.edt.model.ModelObserver;
import amu.licence.edt.model.Schedule;
import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.view.View;

public class Presenter implements ModelObserver {

    private View view;
    private Controller controller;

    public Presenter(Controller controller) {
        this.view = new View(this);
        this.controller = controller;
    }

    public void showView() {
        view.getMainFrame().getFrame().setVisible(true);
    }

    @Override
    public void userChanged(Admin user) {
    }

    @Override
    public void scheduleChanged(Schedule schedule) {
    }

    public void connectButtonPressed() {
        view.showLoginForm(true);
    }

}
