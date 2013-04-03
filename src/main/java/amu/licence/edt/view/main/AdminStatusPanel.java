package amu.licence.edt.view.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;

public class AdminStatusPanel extends ViewComponent {

    private static final String CONNECT_BTN = "connect_btn";
    private static final String DISCONNECT_BTN = "disconnect_btn";

    public final String publicLogin = "utilisateur publique";

    private JLabel lblConnectedAs;
    private JLabel lblConnexionLogin;
    private JPanel pnlConnectLbl;

    private JLabel lblManage;
    private JPanel pnlBtnsManage;
    private JButton btnManageTeachers;
    private JPanel pnlManage;

    private JButton btnConnect;
    private JButton btnDisconnect;
    private JPanel pnlConnectBtn;

    public AdminStatusPanel(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        JPanel panel = new JPanel();

        lblConnectedAs = new JLabel("Connecté en tant que :");
        lblConnexionLogin = new JLabel(publicLogin);
        lblConnexionLogin.setForeground(Color.GREEN);

        pnlConnectLbl = new JPanel(new BorderLayout());
        pnlConnectLbl.add(lblConnectedAs, BorderLayout.NORTH);
        pnlConnectLbl.add(lblConnexionLogin, BorderLayout.CENTER);

        lblManage = new JLabel("Administration");
        pnlBtnsManage = new JPanel();
        pnlBtnsManage.setLayout(new BoxLayout(pnlBtnsManage, BoxLayout.PAGE_AXIS));

        btnManageTeachers = new JButton("Enseignants");
        btnManageTeachers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnManageTeachersActionPerformed(e);
            }
        });

        pnlManage = new JPanel(new BorderLayout());
        pnlManage.add(lblManage, BorderLayout.NORTH);
        pnlManage.add(pnlBtnsManage, BorderLayout.CENTER);
        pnlManage.setVisible(false);

        btnConnect = new JButton("Connexion");
        btnConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConnectActionPerformed(e);
            }
        });

        btnDisconnect = new JButton("Déconnexion");
        btnDisconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDisconnectActionPerformed(e);
            }
        });

        pnlConnectBtn = new JPanel(new CardLayout());
        pnlConnectBtn.add(btnConnect, CONNECT_BTN);
        pnlConnectBtn.add(btnDisconnect, DISCONNECT_BTN);

        panel.setLayout(new BorderLayout());
        panel.add(pnlConnectLbl, BorderLayout.NORTH);
        panel.add(pnlManage, BorderLayout.CENTER);
        panel.add(pnlConnectBtn, BorderLayout.SOUTH);

        return panel;
    }

    protected void btnConnectActionPerformed(ActionEvent e) {
        presenter.connectButtonPressed();
    }

    protected void btnDisconnectActionPerformed(ActionEvent e) {
        presenter.disconnectButtonPressed();
    }

    public void displayPublicUserStatus() {
        ((CardLayout)pnlConnectBtn.getLayout()).show(pnlConnectBtn, CONNECT_BTN);
        lblConnexionLogin.setText(publicLogin);
        pnlBtnsManage.removeAll();
        pnlManage.setVisible(false);
    }

    public void displayAdminUser(Admin user) {
        ((CardLayout)pnlConnectBtn.getLayout()).show(pnlConnectBtn, DISCONNECT_BTN);
        lblConnexionLogin.setText(user.getLogin());
        if (user.isTeacherAdmin()) {
            pnlBtnsManage.add(btnManageTeachers);
        }
        for (Level l : user.getLevels()) {
            JButton btnManageLevel = new JButton(l.getCode());
            btnManageLevel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnManageLevelActionPerformed(e);
                }
            });
            pnlBtnsManage.add(btnManageLevel);
        }
        if (pnlBtnsManage.getComponentCount() == 0) {
            JLabel lblNothingToAdmin = new JLabel("Nothing to administrate");
            pnlBtnsManage.add(lblNothingToAdmin);
        }
        try {   // if it's a teacher, show services hours
            Teacher t = (Teacher) user;     // ok if it passes
            lblConnexionLogin.setText(lblConnexionLogin.getText() + " (" + t.computeServiceHours() + ")");
        } catch (ClassCastException cce) {}
        pnlManage.setVisible(true);
    }

    protected void btnManageLevelActionPerformed(ActionEvent e) {
        presenter.manageLevelButtonPressed(((JButton) e.getSource()).getText());
    }

    protected void btnManageTeachersActionPerformed(ActionEvent e) {
        presenter.manageTeachersButtonPressed();
    }

}
