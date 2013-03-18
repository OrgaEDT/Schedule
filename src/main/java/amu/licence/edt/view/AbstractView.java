package amu.licence.edt.view;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;

public abstract class AbstractView {

    protected ScheduleModel model;
    protected ScheduleController controller;

    public AbstractView(ScheduleModel model, ScheduleController controller) {
        this.model = model;
        this.controller = controller;
    }

}
