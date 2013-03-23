package amu.licence.edt.presenter;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.view.MainFrame;

public class SchedulePresenter {

    private MainFrame mainFrame;
    private ScheduleController controller;

    public SchedulePresenter(ScheduleModel model) {
        this.mainFrame = new MainFrame(model, this);
        this.controller = new ScheduleController(model);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

}
