package amu.licence.edt.view.main.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.TableCellRenderer;

public class SpanTableUI extends BasicTableUI {

    @Override
    public void paint(Graphics g, JComponent c) {
        if (! (table.getModel() instanceof SpanTableModel)) {
            throw new IllegalStateException(
                    "Cannot paint table with SpanTableUI : model is not a SpanTableModel");
        }
        Rectangle r = g.getClipBounds();
        int firstRow = table.rowAtPoint(new Point(0, r.y));
        int lastRow = table.rowAtPoint(new Point(0, r.y + r.height));
        // -1 is a flag that the ending point is outside the table
        if (lastRow < 0)
            lastRow = table.getRowCount() - 1;
        for (int i = firstRow; i <= lastRow; i++)
            paintRow(g, i);
    }

    private void paintRow(Graphics g, int row) {
        Rectangle r = g.getClipBounds();
        for (int i = 0; i < table.getColumnCount(); i++) {
            Rectangle r1 = table.getCellRect(row, i, true);
            if (r1.intersects(r)) { // at least a part is visible
                int sk = ((SpanTableModel) table.getModel()).getSpanModel().spanIndex(row, i);
                paintCell(g, row, sk, r1);
                // increment the column counter
                i += ((SpanTableModel) table.getModel()).getSpanModel().spanSize(row, sk) - 1;
            }
        }
    }

    private void paintCell(Graphics g, int row, int column, Rectangle area) {
        int verticalMargin = table.getRowMargin();
        int horizontalMargin = table.getColumnModel().getColumnMargin();

        Color c = g.getColor();
        g.setColor(table.getGridColor());
        g.drawRect(area.x, area.y, area.width - 1, area.height - 1);
        g.setColor(c);

        area.setBounds(area.x + horizontalMargin / 2, area.y + verticalMargin
                / 2, area.width - horizontalMargin, area.height
                - verticalMargin);

        if (table.isEditing() && table.getEditingRow() == row
                && table.getEditingColumn() == column) {
            Component component = table.getEditorComponent();
            component.setBounds(area);
            component.validate();
        } else {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component component = table.prepareRenderer(renderer, row, column);
            if (component.getParent() == null)
                rendererPane.add(component);
            rendererPane.paintComponent(g, component, table, area.x, area.y,
                    area.width, area.height, true);
        }
    }

}
