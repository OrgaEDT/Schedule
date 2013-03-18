package amu.licence.edt.view;

import javax.swing.JTree;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;

public class ScheduleTreeView extends AbstractComponentView {

    public ScheduleTreeView(ScheduleModel model, ScheduleController controller) {
        super(model, controller);
    }

    @Override
    protected void createView() {
        JTree tree = new JTree();

        component = tree;
    }

}
