package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JTree;

import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.presenter.SchedulePresenter;

public class SchedulesTree extends ViewComponent {

    public SchedulesTree(ScheduleModel model, SchedulePresenter presenter) {
        super(model, presenter);
    }

    @Override
    public JComponent createComponent() {
        return new JTree();
    }


}
