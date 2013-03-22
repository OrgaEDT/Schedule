package amu.licence.edt.view;

import javax.swing.JTable;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.model.beans.TU;

public class ScheduleTableView extends AbstractComponentView {

    public ScheduleTableView(ScheduleModel model, ScheduleController controller) {
        super(model, controller);
    }

    @Override
    protected void createView() {
        JTable table = new JTable(new ScheduleTableModel());

        table.setDefaultRenderer(TU.class, new ScheduleTableCellRenderer());

        component = table;
    }


}
