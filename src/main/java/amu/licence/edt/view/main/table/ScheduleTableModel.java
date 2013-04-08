package amu.licence.edt.view.main.table;

import java.util.Calendar;
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
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < entete.length; ++j) {
                data[i][j] = null;
            }
        }
        spanModel.clear();
        Calendar c = Calendar.getInstance();
        for (Session s : sessions) {
            int row, col;
            c.setTime(s.getStartDate());
            row = c.get(Calendar.DAY_OF_WEEK) - Calendar.MONDAY;
            col = c.get(Calendar.HOUR_OF_DAY) - 8;
            if (s.getDuration() > 1) {
                spanModel.addSpan(new Span(row, col, s.getDuration()));
            }
            data[row][col] = s;
        }
        fireTableDataChanged();
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
