package amu.licence.edt.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amu.licence.edt.model.ScheduleModel;
import amu.licence.edt.presenter.SchedulePresenter;

public class AdminStatusPanel extends ViewComponent {

    private JLabel lblStatus;
    private JPanel pnlInfos;
    private JButton btnConnect;

    public AdminStatusPanel(ScheduleModel model, SchedulePresenter presenter) {
        super(model, presenter);
    }

    @Override
    public JComponent createComponent() {
        JPanel panel = new JPanel();

        lblStatus = new JLabel("unknown");
        pnlInfos = new JPanel();

        btnConnect = new JButton("Connexion");
        btnConnect.addActionListener(null);

        panel.setLayout(new BorderLayout());
        panel.add(lblStatus, BorderLayout.NORTH);
        panel.add(pnlInfos, BorderLayout.CENTER);
        panel.add(btnConnect, BorderLayout.SOUTH);

        return panel;
    }

}
