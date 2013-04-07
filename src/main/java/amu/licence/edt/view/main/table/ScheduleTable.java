package amu.licence.edt.view.main.table;

import amu.licence.edt.model.beans.TU;


public class ScheduleTable extends SpanTable {
    private static final long serialVersionUID = 1L;

    public ScheduleTable(ScheduleTableModel model) {
        super(model);
        setDefaultRenderer(TU.class, new ScheduleTableCellRenderer());
    }

    public void refreshTable() {
    }

}
