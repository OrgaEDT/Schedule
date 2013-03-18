package amu.licence.edt.view;

import javax.swing.JTable;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.model.beans.UE;

public class ScheduleTableView extends AbstractComponentView {

    public ScheduleTableView(ScheduleModel model, ScheduleController controller) {
        super(model, controller);
    }

    @Override
    protected void createView() {
        JTable table = new JTable(new ScheduleTableModel());

        table.setDefaultRenderer(UE.class, new ScheduleTableCellRenderer());

        component = table;
    }


}
