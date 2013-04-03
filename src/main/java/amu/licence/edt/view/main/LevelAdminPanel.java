package amu.licence.edt.view.main;

import javax.swing.JComponent;
import javax.swing.JPanel;

import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;

public class LevelAdminPanel extends ViewComponent {


    public LevelAdminPanel(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        return new JPanel();
    }

}
