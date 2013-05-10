package amu.licence.edt.view;

import java.util.HashMap;

import amu.licence.edt.model.beans.Level;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.dialogs.CRoomTeacherChooser;
import amu.licence.edt.view.dialogs.LevelManagmentForm;
import amu.licence.edt.view.dialogs.LoginForm;
import amu.licence.edt.view.dialogs.TeacherManagmentForm;
import amu.licence.edt.view.main.MainFrame;

public class View extends AbstractView {

    private MainFrame mainFrame;
    private LoginForm loginForm;
    private TeacherManagmentForm teacherManagmentForm;
    private HashMap<Level, LevelManagmentForm> levelManagmentForms;
    private CRoomTeacherChooser croomTeacherChooser;

    public View(Presenter presenter) {
        super(presenter);
        mainFrame = new MainFrame(presenter);
        loginForm = new LoginForm(presenter, mainFrame.getFrame());
        teacherManagmentForm = new TeacherManagmentForm(presenter, mainFrame.getFrame());
        levelManagmentForms = new HashMap<Level, LevelManagmentForm>();
        croomTeacherChooser = new CRoomTeacherChooser(presenter, mainFrame.getFrame());
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

    public LevelManagmentForm getLevelManagmentForm(Level l) {
        LevelManagmentForm lmf = levelManagmentForms.get(l);
        if (lmf == null) {
            lmf = new LevelManagmentForm(presenter, mainFrame.getFrame(), l);
            levelManagmentForms.put(l, lmf);
        }
        return lmf;
    }

    public CRoomTeacherChooser getCRoomTeacherChooser() {
        return croomTeacherChooser;
    }

}
