package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JTree;

import amu.licence.edt.presenter.SchedulePresenter;

public class SchedulesTree extends ViewComponent {

    public SchedulesTree(SchedulePresenter presenter) {
        super(presenter);
    }

    @Override
    public JComponent createComponent() {
        return new JTree();
    }


}
