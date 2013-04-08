package amu.licence.edt.view.main.table;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import amu.licence.edt.model.beans.Session;

public class ScheduleTableCellRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                                            row, column);

        if (value == null) {
            setBackground(Color.WHITE);
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
        try {
            Session s = (Session) value;
            setText(s.gettU().getCode() + " " + s.getcRoom().getNum());
            setBackground(Color.LIGHT_GRAY);
        } catch (ClassCastException cce) {
            System.err.println("not a Session");// TODO exc ?
        }

        return this;
    }

}
