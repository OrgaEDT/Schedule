package amu.licence.edt.view.main.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import amu.licence.edt.model.beans.Session;
import amu.licence.edt.model.beans.TU;

public class ScheduleTableModel extends AbstractTableModel implements SpanTableModel {
    private static final long serialVersionUID = 1L;

    private SpanModel spanModel = new SpanModel();
    private Session[][] data;
    private final String[] entete = { "8h", "9h", "10h", "11h", "12h", "13h", "14h", "15h", "16h", "17h", "18h", "19h" };

    public ScheduleTableModel() {
        super();
        this.data = new Session[5][entete.length];
    }

    public void fillData(List<Session> sessions) {
        // TODO
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
        return data.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return entete[columnIndex];
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        return data[arg0][arg1];
    }

    @Override
    public SpanModel getSpanModel() {
        return spanModel;
    }

}
