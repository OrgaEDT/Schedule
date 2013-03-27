package amu.licence.edt.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import amu.licence.edt.presenter.Presenter;

public class LoginForm extends ViewComponent {

    private Frame owner;

    private JLabel lblError;

    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField usernameInput;
    private JPasswordField passwordInput;

    private JPanel pnlUsernamePassword;

    private JButton btnSubmit;

    public LoginForm(Presenter presenter, Frame owner) {
        super(presenter);
        this.owner = owner;
    }

    @Override
    protected Component createComponent() {
        JDialog dialog = new JDialog(owner, true);
        dialog.setTitle("Formulaire de connexion");
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                 component.setLocation(owner.getLocation());
            }
            @Override
            public void windowClosing(WindowEvent e) {
                refresh();
            }
        });

        lblError = new JLabel("login/mot de passe invalide");
        lblError.setFont(new Font(lblError.getFont().getName(), Font.BOLD, lblError.getFont().getSize()));
        lblError.setForeground(Color.RED);
        lblError.setVisible(false);

        lblUsername = new JLabel("login : ");
        usernameInput = new JTextField();

        lblPassword = new JLabel("mot de passe : ");
        passwordInput = new JPasswordField();

        pnlUsernamePassword = new JPanel(new GridLayout(2, 2));
        pnlUsernamePassword.add(lblUsername);
        pnlUsernamePassword.add(usernameInput);
        pnlUsernamePassword.add(lblPassword);
        pnlUsernamePassword.add(passwordInput);

        btnSubmit = new JButton("Valider");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSubmitActionListener(e);
            }
        });

        dialog.setLayout(new GridLayout(0, 1));

        dialog.add(lblError);
        dialog.add(pnlUsernamePassword);
        dialog.add(btnSubmit);

        dialog.pack();
        return dialog;
    }

    public void clearTextFields() {
        usernameInput.setText("");
        passwordInput.setText("");
    }

    public void showErrorLbl(boolean b) {
        lblError.setVisible(b);
    }

    public void refresh() {
        clearTextFields();
        showErrorLbl(false);
    }

    protected void btnSubmitActionListener(ActionEvent e) {
        presenter.validateLoginButtonPressed(usernameInput.getText(), new String(passwordInput.getPassword()));
    }

}
