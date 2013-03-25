package amu.licence.edt.view;

import amu.licence.edt.presenter.Presenter;

public abstract class AbstractView {

    protected Presenter presenter;

    public AbstractView(Presenter presenter) {
        this.presenter = presenter;
    }

}
