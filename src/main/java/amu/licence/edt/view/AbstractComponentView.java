package amu.licence.edt.view;

import javax.swing.JComponent;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;

public abstract class AbstractComponentView extends AbstractView {

    protected JComponent component;

    public AbstractComponentView(ScheduleModel model, ScheduleController controller) {
        super(model, controller);
        createView();
    }

    public JComponent getComponent() {
        return this.component;
    }

    protected abstract void createView();

}
