package amu.licence.edt.view.main.table;

import java.awt.Color;

import javax.swing.table.AbstractTableModel;

import amu.licence.edt.model.beans.TU;

public class ScheduleTableModel extends AbstractTableModel implements SpanTableModel {
    private static final long serialVersionUID = 1L;

    private SpanModel spanModel = new SpanModel();
    private final TU[][] donnees;
    private final String[] entete = { "8h", "10h", "12h", "14h", "16h", "18h" };

    public ScheduleTableModel() {
        super();
        donnees = new TU[][] {
                { new TU("ue1", Color.decode("#BBBBBB")),
                        new TU("ue2", Color.RED), new TU("ue3", Color.BLUE),
                        new TU("ue1", Color.decode("#BBBBBB")),
                        new TU("ue2", Color.RED), new TU("ue3", Color.BLUE) },
                { new TU("ue4", Color.YELLOW), new TU("ue5", Color.GRAY),
                        new TU("ue6", Color.GREEN),
                        new TU("ue4", Color.YELLOW), new TU("ue5", Color.GRAY),
                        new TU("ue6", Color.GREEN) }, };
        spanModel.addSpan(new Span(0, 1, 4));
        spanModel.addSpan(new Span(1, 3, 2));
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

    @Override
    public SpanModel getSpanModel() {
        return spanModel;
    }

}