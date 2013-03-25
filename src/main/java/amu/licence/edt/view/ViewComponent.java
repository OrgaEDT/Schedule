package amu.licence.edt.view;

import java.awt.Component;

import amu.licence.edt.presenter.Presenter;

public abstract class ViewComponent extends AbstractView {

    protected Component component;

    public ViewComponent(Presenter presenter) {
        super(presenter);
        this.component = createComponent();
    }

    public Component getComponent() {
        return component;
    }

    protected abstract Component createComponent();

}
