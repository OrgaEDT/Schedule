package amu.licence.edt.view;

import javax.swing.JComponent;

import amu.licence.edt.presenter.Presenter;

public abstract class ViewComponent extends AbstractView {

    protected JComponent component;

    public ViewComponent(Presenter presenter) {
        super(presenter);
        this.component = createComponent();
    }

    public JComponent getComponent() {
        return component;
    }

    protected abstract JComponent createComponent();

}
