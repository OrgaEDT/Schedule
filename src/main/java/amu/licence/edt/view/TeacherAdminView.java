package amu.licence.edt.view;

import javax.swing.JPanel;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;

public class TeacherAdminView extends AbstractComponentView {

    public TeacherAdminView(ScheduleModel model, ScheduleController controller) {
        super(model, controller);
    }

    @Override
    protected void createView() {
        JPanel panel = new JPanel();

        component = panel;
    }

}
