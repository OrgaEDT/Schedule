package amu.licence.edt.view.main.table;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import amu.licence.edt.model.beans.Session;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;

public class ScheduleTableComponent extends ViewComponent {

    private ScheduleTable table;
    private ScheduleTableModel tableModel;

    public ScheduleTableComponent(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        tableModel = new ScheduleTableModel();
        tableModel.fillData(presenter.tableCreating());
        table = new ScheduleTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setRowHeaderView(tableModel.getRowHeader());
        return scrollPane;
    }

    public void displaySessions(List<Session> sessions) {
        tableModel.clear();
        tableModel.fillData(sessions);
    }

}
