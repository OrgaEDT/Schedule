package amu.licence.edt.view;

import amu.licence.edt.presenter.Presenter;

public class View extends AbstractView {

    private MainFrame mainFrame;
    private LoginForm loginForm;

    public View(Presenter presenter) {
        super(presenter);
        mainFrame = new MainFrame(presenter);
        loginForm = new LoginForm(presenter, mainFrame.getFrame());
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void showLoginForm(boolean b) {
        loginForm.getComponent().setVisible(b);
    }

}
