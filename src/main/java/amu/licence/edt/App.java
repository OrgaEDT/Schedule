package amu.licence.edt;

import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.presenter.SchedulePresenter;

public class App {

    public static void main( String[] args ) {
        ScheduleModel model = new ScheduleModel();
        SchedulePresenter presenter = new SchedulePresenter(model);
        presenter.getMainFrame().getFrame().setVisible(true);
    }

}
