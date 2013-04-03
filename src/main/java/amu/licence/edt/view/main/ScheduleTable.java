package amu.licence.edt.view.main;

import javax.swing.JComponent;
import javax.swing.JTable;

import amu.licence.edt.model.beans.TU;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;

public class ScheduleTable extends ViewComponent {

    public ScheduleTable(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        JTable table = new JTable(new ScheduleTableModel());
        table.setDefaultRenderer(TU.class, new ScheduleTableCellRenderer());
        return table;
    }

}
