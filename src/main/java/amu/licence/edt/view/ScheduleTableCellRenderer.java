package amu.licence.edt.view;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import amu.licence.edt.model.beans.TU;

public class ScheduleTableCellRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                                            row, column);

        try {
            TU ue = (TU) value;
            setText(ue.getLibel());
            setBackground(ue.getColor());
        } catch (ClassCastException cce) {
            System.err.println("not a UE");// TODO exc ?
        }

        return this;
    }

}
