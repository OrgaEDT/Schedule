package amu.licence.edt.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;

public class AdminStatusView extends AbstractComponentView {

    private JLabel lblStatus;
    private JPanel pnlInfos;
    private JButton btnConnect;

    public AdminStatusView(ScheduleModel model, ScheduleController controller) {
        super(model, controller);
    }

    @Override
    protected void createView() {
        JPanel panel = new JPanel();

        lblStatus = new JLabel("Public");
        pnlInfos = new JPanel();

        btnConnect = new JButton("Connexion");
        btnConnect.addActionListener(null);

        panel.setLayout(new BorderLayout());
        panel.add(lblStatus, BorderLayout.NORTH);
        panel.add(pnlInfos, BorderLayout.CENTER);
        panel.add(btnConnect, BorderLayout.SOUTH);

        component = panel;
    }

}
