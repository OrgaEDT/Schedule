package amu.licence.edt.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import amu.licence.edt.presenter.Presenter;

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
        pnlBtnsManage = new JPanel(new FlowLayout());

        btnManageTeachers = new JButton("Enseignants");
        btnManageTeachers.addActionListener(null);

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
        btnDisconnect.addActionListener(null);

        pnlConnectBtn = new JPanel(new CardLayout());
        pnlConnectBtn.add(btnConnect, CONNECT_BTN);
        pnlConnectBtn.add(btnDisconnect, DISCONNECT_BTN);

        panel.setLayout(new BorderLayout());
        panel.add(pnlConnectLbl, BorderLayout.NORTH);
        panel.add(pnlManage, BorderLayout.CENTER);
        panel.add(pnlConnectBtn, BorderLayout.SOUTH);

        return panel;
    }

    private void btnConnectActionPerformed(ActionEvent e) {
        presenter.connectButtonPressed();
    }

}
