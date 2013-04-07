package amu.licence.edt.view.main.table;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class SpanTable extends JTable {
    private static final long serialVersionUID = 1L;

    public SpanTable(SpanTableModel spanTableModel) {
        super(spanTableModel);
        setUI(new SpanTableUI());
    }

    @Override
    public Rectangle getCellRect(int row, int column, boolean includeSpacing) {
        if (getSpanModel() == null)   // cuz getCellRect is used in JTable constructor
            return super.getCellRect(row, column, includeSpacing);

        Rectangle rect = super.getCellRect(row, column, includeSpacing);
        Span span = getSpanModel().getDefinedSpan(row, column);
        if (span != null) { // then expand the rectangle width with the span
            for (int i = 1; i < span.getWidth(); i++) {
                rect.width += getColumnModel().getColumn(span.getColumn() + i).getWidth();
            }
        }
        return rect;
    }

    @Override
    public int columnAtPoint(Point p) {
        int col = super.columnAtPoint(p);
        // -1 is returned by columnAtPoint if the point is not in the table
        return (col < 0) ? col : getSpanModel().spanIndex(super.rowAtPoint(p), col);
    }

    private SpanModel getSpanModel() {
        // cast OK cuz model is filtered in constructor and setModel() override below
        return ((SpanTableModel) getModel()).getSpanModel();
    }

    @Override
    public void setModel(TableModel tableModel) {
        if (! (tableModel instanceof SpanTableModel)) {
            throw new IllegalArgumentException("Canot set model of SpanTable : not a SpanTableModel.");
        }
        super.setModel(tableModel);
    }

}
