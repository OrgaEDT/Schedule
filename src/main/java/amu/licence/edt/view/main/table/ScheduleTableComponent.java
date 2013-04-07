package amu.licence.edt.view.main.table;

import javax.swing.JComponent;

import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;

public class ScheduleTableComponent extends ViewComponent {

    public ScheduleTableComponent(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        return new ScheduleTable(new ScheduleTableModel());
    }

}
