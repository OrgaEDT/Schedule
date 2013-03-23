package amu.licence.edt.view;

import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.presenter.SchedulePresenter;

public abstract class AbstractView {

    protected SchedulePresenter presenter;
    protected ScheduleModel model;

    public AbstractView(ScheduleModel model, SchedulePresenter presenter) {
        this.presenter = presenter;
        this.model = model;
    }

}
