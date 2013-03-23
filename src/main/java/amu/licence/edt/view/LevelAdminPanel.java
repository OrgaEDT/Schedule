package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.presenter.SchedulePresenter;

public class LevelAdminPanel extends ViewComponent {


    public LevelAdminPanel(ScheduleModel model, SchedulePresenter presenter) {
        super(model, presenter);
    }

    @Override
    public JComponent createComponent() {
        return new JPanel();
    }

}
