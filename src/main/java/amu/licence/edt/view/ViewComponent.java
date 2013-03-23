package amu.licence.edt.view;

import javax.swing.JComponent;

import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.presenter.SchedulePresenter;

public abstract class ViewComponent extends AbstractView {

    protected JComponent component;

    public ViewComponent(ScheduleModel model, SchedulePresenter presenter) {
        super(model, presenter);
        this.component = createComponent();
    }

    public JComponent getComponent() {
        return component;
    }

    public abstract JComponent createComponent();

}
