package amu.licence.edt.view.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import amu.licence.edt.model.dao.DAOFactoryManager;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.AbstractView;

public class MainFrame extends AbstractView {

    JFrame frame;

    JPanel pnlCenter;
    JPanel pnlSide;

    AdminStatusPanel adminStatusPanel;
    SchedulesTree schedulesTree;
    ScheduleTable scheduleTable;
    ScheduleStatusPanel scheduleStatusPanel;

    public MainFrame(Presenter presenter) {
        super(presenter);
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DAOFactoryManager.getDAOFactory().finish();
            }
        });

        frame.setTitle("Schedule");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.getContentPane().setLayout(new BorderLayout());

        pnlCenter = new JPanel();
        pnlSide = new JPanel();

        adminStatusPanel = new AdminStatusPanel(presenter);
        schedulesTree = new SchedulesTree(presenter);
        scheduleTable = new ScheduleTable(presenter);
        scheduleStatusPanel = new ScheduleStatusPanel(presenter);

        pnlCenter.setLayout(new BorderLayout());
        pnlCenter.add(scheduleStatusPanel.getComponent(), BorderLayout.NORTH);
        pnlCenter.add(scheduleTable.getComponent(), BorderLayout.CENTER);

        pnlSide.setLayout(new BorderLayout());
        pnlSide.add(new JScrollPane(schedulesTree.getComponent()), BorderLayout.CENTER);
        pnlSide.add(adminStatusPanel.getComponent(), BorderLayout.SOUTH);

        frame.getContentPane().add(pnlCenter, BorderLayout.CENTER);
        frame.getContentPane().add(pnlSide, BorderLayout.WEST);

        frame.pack();
    }

    public JFrame getFrame() {
        return frame;
    }

    public AdminStatusPanel getAdminStatusPanel() {
        return adminStatusPanel;
    }

    public ScheduleStatusPanel getScheduleStatusPanel() {
        return scheduleStatusPanel;
    }

}
