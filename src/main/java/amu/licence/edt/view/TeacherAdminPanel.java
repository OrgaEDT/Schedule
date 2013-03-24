package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import amu.licence.edt.presenter.SchedulePresenter;

public class TeacherAdminPanel extends ViewComponent {

    public TeacherAdminPanel(SchedulePresenter presenter) {
        super(presenter);
    }

    @Override
    public JComponent createComponent() {
        return new JPanel();
    }
}
