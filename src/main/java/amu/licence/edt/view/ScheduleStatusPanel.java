package amu.licence.edt.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amu.licence.edt.presenter.Presenter;

public class ScheduleStatusPanel extends ViewComponent {

    private final String DFLT_LBL_TXT = "vide";

    private JButton btnLeft;
    private JButton btnRight;
    private JLabel label;

    public ScheduleStatusPanel(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        JPanel panel = new JPanel();

        btnLeft = new JButton("left");
        btnLeft.addActionListener(null);

        btnRight = new JButton("right");
        btnRight.addActionListener(null);

        label = new JLabel(DFLT_LBL_TXT);

        panel.setLayout(new FlowLayout());
        panel.add(btnLeft);
        panel.add(label);
        panel.add(btnRight);

        return panel;
    }

    public void setLabelText(String text) {
        label.setText(text != null ? text : DFLT_LBL_TXT);
    }

}
