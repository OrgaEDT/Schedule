package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import amu.licence.edt.presenter.Presenter;

public class TeacherAdminPanel extends ViewComponent {

    public TeacherAdminPanel(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        return new JPanel();
    }
}
