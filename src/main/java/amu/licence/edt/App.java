package amu.licence.edt;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.presenter.SchedulePresenter;

public class App {

    public static void main( String[] args ) {
        ScheduleModel model = new ScheduleModel();
        ScheduleController controller = new ScheduleController(model);
        SchedulePresenter presenter = new SchedulePresenter(controller);
        presenter.getMainFrame().getFrame().setVisible(true);
    }

}
