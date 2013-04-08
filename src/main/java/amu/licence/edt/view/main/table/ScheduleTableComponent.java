package amu.licence.edt.view.main.table;

import java.awt.Component;

import javax.swing.AbstractListModel;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.table.JTableHeader;

import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;

class RowHeaderRenderer extends JLabel implements ListCellRenderer {
    private static final long serialVersionUID = 1L;

    RowHeaderRenderer(JTable table) {
        JTableHeader header = table.getTableHeader();
        setOpaque(true);
        setBorder(UIManager.getBorder("TableHeader.cellBorder"));
        setHorizontalAlignment(CENTER);
        setForeground(header.getForeground());
        setBackground(header.getBackground());
        setFont(header.getFont());
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

public class ScheduleTableComponent extends ViewComponent {

    public ScheduleTableComponent(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        JTable table = new ScheduleTable(new ScheduleTableModel());

        JList rowHeader = new JList(new AbstractListModel() {
            private static final long serialVersionUID = 1L;

            String semaine[] = { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi" };

            @Override
            public int getSize() {
                return semaine.length;
            }

            @Override
            public Object getElementAt(int index) {
                return semaine[index];
            }
        });
        rowHeader.setFixedCellWidth(100);

//        rowHeader.setFixedCellHeight(table.getRowHeight() * 3 + table.getRowMargin());
        rowHeader.setFixedCellHeight(table.getRowHeight() + table.getRowMargin());
        rowHeader.setCellRenderer(new RowHeaderRenderer(table));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setRowHeaderView(rowHeader);
        return scrollPane;
    }

}
