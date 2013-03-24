package amu.licence.edt.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import amu.licence.edt.presenter.SchedulePresenter;

public class MainFrame extends AbstractView {

    JFrame frame;

    JPanel pnlCenter;
    JPanel pnlSide;
    JPanel pnlAdmin;

    ViewComponent adminStatusPanel;
    ViewComponent schedulesTree;
    ViewComponent scheduleTable;
    ViewComponent scheduleStatusPanel;
    ViewComponent levelAdminPanel;
    ViewComponent teacherAdminPanel;

    public MainFrame(SchedulePresenter presenter) {
        super(presenter);
        frame = new JFrame();

        frame.setTitle("Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        pnlCenter = new JPanel();
        pnlSide = new JPanel();
        pnlAdmin = new JPanel();

        adminStatusPanel = new AdminStatusPanel(presenter);
        schedulesTree = new SchedulesTree(presenter);
        scheduleTable = new ScheduleTable(presenter);
        scheduleStatusPanel = new ScheduleStatusPanel(presenter);
        levelAdminPanel = new LevelAdminPanel(presenter);
        teacherAdminPanel = new TeacherAdminPanel(presenter);

        pnlCenter.setLayout(new BorderLayout());
        pnlCenter.add(scheduleStatusPanel.getComponent(), BorderLayout.NORTH);
        pnlCenter.add(scheduleTable.getComponent(), BorderLayout.CENTER);

        pnlSide.setLayout(new BorderLayout());
        pnlSide.add(schedulesTree.getComponent(), BorderLayout.CENTER);
        pnlSide.add(adminStatusPanel.getComponent(), BorderLayout.SOUTH);

        pnlAdmin.setLayout(new BorderLayout());
        pnlAdmin.add(levelAdminPanel.getComponent(), BorderLayout.NORTH);
        pnlAdmin.add(teacherAdminPanel.getComponent(), BorderLayout.SOUTH);

        frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
        frame.getContentPane().add(pnlSide, BorderLayout.WEST);
        frame.getContentPane().add(pnlAdmin, BorderLayout.EAST);

        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

}
