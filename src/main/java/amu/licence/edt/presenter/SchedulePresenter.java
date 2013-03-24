package amu.licence.edt.presenter;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.view.MainFrame;

public class SchedulePresenter {

    private MainFrame mainFrame;
    private ScheduleController controller;

    public SchedulePresenter(ScheduleController controller) {
        this.mainFrame = new MainFrame(this);
        this.controller = controller;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

}
