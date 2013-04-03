package amu.licence.edt.view;

import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.dialogs.LoginForm;
import amu.licence.edt.view.dialogs.TeacherManagmentForm;
import amu.licence.edt.view.main.MainFrame;

public class View extends AbstractView {

    private MainFrame mainFrame;
    private LoginForm loginForm;
    private TeacherManagmentForm teacherManagmentForm;

    public View(Presenter presenter) {
        super(presenter);
        mainFrame = new MainFrame(presenter);
        loginForm = new LoginForm(presenter, mainFrame.getFrame());
        teacherManagmentForm = new TeacherManagmentForm(presenter, mainFrame.getFrame());
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public TeacherManagmentForm getTeacherManagmentForm() {
        return teacherManagmentForm;
    }

}
