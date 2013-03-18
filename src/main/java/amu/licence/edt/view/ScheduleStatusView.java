package amu.licence.edt.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amu.licence.edt.controller.ScheduleController;
import amu.licence.edt.model.ScheduleModel;

public class ScheduleStatusView extends AbstractComponentView {

    private JButton btnLeft;
    private JButton btnRight;
    private JLabel lblSchedule;
    private JLabel lblWho;
    private JLabel lblWhat;
    private JLabel lblWhen;

    public ScheduleStatusView(ScheduleModel model, ScheduleController controller) {
        super(model, controller);
    }

    @Override
    protected void createView() {
        JPanel panel = new JPanel();

        // TODO image
        btnLeft = new JButton("left");
        btnLeft.addActionListener(null);

        btnRight = new JButton("right");
        btnRight.addActionListener(null);

        lblSchedule = new JLabel("Emploi du temps");
        lblWho = new JLabel();
        lblWhat = new JLabel();
        lblWhen = new JLabel();

        panel.setLayout(new FlowLayout());
        panel.add(btnLeft);
        panel.add(lblSchedule);
        panel.add(lblWho);
        panel.add(lblWhat);
        panel.add(lblWhen);
        panel.add(btnRight);

        component = panel;
    }

}
