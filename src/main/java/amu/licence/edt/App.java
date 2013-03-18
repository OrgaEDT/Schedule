package amu.licence.edt;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.view.AdminStatusView;
import amu.licence.edt.view.AdminTeacherView;
import amu.licence.edt.view.AdminYearView;
import amu.licence.edt.view.ScheduleStatusView;
import amu.licence.edt.view.ScheduleTableView;
import amu.licence.edt.view.ScheduleTreeView;

public class App
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame("Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel pnlCenter = new JPanel();
        JPanel pnlSide = new JPanel();
        JPanel pnlAdmin = new JPanel();

        ScheduleModel model = new ScheduleModel();
        ScheduleController controller = new ScheduleController(model);

        AdminStatusView adminView = new AdminStatusView(model, controller);
        ScheduleTreeView treeView = new ScheduleTreeView(model, controller);
        ScheduleTableView tableView = new ScheduleTableView(model, controller);
        ScheduleStatusView statusView = new ScheduleStatusView(model, controller);
        AdminYearView yearView = new AdminYearView(model, controller);
        AdminTeacherView teacherView = new AdminTeacherView(model, controller);

        pnlCenter.setLayout(new BorderLayout());
        pnlCenter.add(statusView.getComponent(), BorderLayout.NORTH);
        pnlCenter.add(tableView.getComponent(), BorderLayout.CENTER);

        pnlSide.setLayout(new BorderLayout());
        pnlSide.add(treeView.getComponent(), BorderLayout.CENTER);
        pnlSide.add(adminView.getComponent(), BorderLayout.SOUTH);

        pnlAdmin.setLayout(new BorderLayout());
        pnlAdmin.add(yearView.getComponent(), BorderLayout.NORTH);
        pnlAdmin.add(teacherView.getComponent(), BorderLayout.SOUTH);

        frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
        frame.getContentPane().add(pnlSide, BorderLayout.WEST);
        frame.getContentPane().add(pnlAdmin, BorderLayout.EAST);

        frame.pack();
        frame.setVisible(true);
    }
}
