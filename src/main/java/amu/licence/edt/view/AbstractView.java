package amu.licence.edt.view;

import amu.licence.edt.presenter.SchedulePresenter;

public abstract class AbstractView {

    protected SchedulePresenter presenter;

    public AbstractView(SchedulePresenter presenter) {
        this.presenter = presenter;
    }

}
