package amu.licence.edt.view;

import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.dialogs.LoginForm;
import amu.licence.edt.view.main.MainFrame;

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

    public LoginForm getLoginForm() {
        return loginForm;
    }

}
