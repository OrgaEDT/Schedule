package amu.licence.edt.view;

import javax.swing.JComponent;

import amu.licence.edt.presenter.SchedulePresenter;

public abstract class ViewComponent extends AbstractView {

    protected JComponent component;

    public ViewComponent(SchedulePresenter presenter) {
        super(presenter);
        this.component = createComponent();
    }

    public JComponent getComponent() {
        return component;
    }

    protected abstract JComponent createComponent();

}
