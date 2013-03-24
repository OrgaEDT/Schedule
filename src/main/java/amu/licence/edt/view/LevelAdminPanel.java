package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import amu.licence.edt.presenter.SchedulePresenter;

public class LevelAdminPanel extends ViewComponent {


    public LevelAdminPanel(SchedulePresenter presenter) {
        super(presenter);
    }

    @Override
    public JComponent createComponent() {
        return new JPanel();
    }

}
