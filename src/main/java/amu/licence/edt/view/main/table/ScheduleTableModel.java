package amu.licence.edt.view.main.table;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;

import amu.licence.edt.model.beans.TU;

public class ScheduleTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;

    private final TU[][] donnees;
    private final String[] entete = { "matin", "midi", "soir" };

    public ScheduleTableModel() {
        super();
        donnees = new TU[][] {
                { new TU("ue1", Color.decode("#BBBBBB")),
                        new TU("ue2", Color.RED), new TU("ue3", Color.BLUE) },
                { new TU("ue4", Color.YELLOW), new TU("ue5", Color.GRAY),
                        new TU("ue6", Color.GREEN) }, };
    }

    @Override
    public Class<TU> getColumnClass(int columnIndex) {
        return TU.class;
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public int getRowCount() {
        return donnees.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entete[columnIndex];
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        return donnees[arg0][arg1];
    }

}
