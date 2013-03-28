package amu.licence.edt.presenter;

import javax.swing.tree.TreeNode;

import amu.licence.edt.controller.Controller;
import amu.licence.edt.model.ModelObserver;
import amu.licence.edt.model.Schedule;
import amu.licence.edt.model.beans.Admin;
import amu.licence.edt.view.View;

public class Presenter implements ModelObserver {

    private View view;
    private Controller controller;

    public Presenter(Controller controller) {
        this.controller = controller;
        this.view = new View(this);
    }

    public void showView() {
        view.getMainFrame().getFrame().setVisible(true);
    }

    @Override
    public void userChanged(Admin user) {
        if (user == null) {
            view.getMainFrame().getAdminStatusPanel().displayPublicUserStatus();
        }
        else {
            view.getMainFrame().getAdminStatusPanel().displayAdminUser(user);
        }
        view.getMainFrame().getFrame().pack();
    }

    @Override
    public void scheduleChanged(Schedule schedule) {
    }

    public void connectButtonPressed() {
        view.getLoginForm().getComponent().setVisible(true);
    }

    public void disconnectButtonPressed() {
        controller.disconnectionRequested();
    }

    public void validateLoginButtonPressed(String login, String password) {
        if (controller.validateLoginRequested(login, password)) {
            view.getLoginForm().getComponent().setVisible(false);
            view.getLoginForm().refresh();
        }
        else {
            view.getLoginForm().showErrorLbl(true);
            view.getLoginForm().clearTextFields();
        }
    }

    public void manageLevelButtonPressed(String levelCode) {
        // TODO
    }

    public TreeNode scheduleTreeCreating() {
        return controller.scheduleRootNodeRequested();
    }

}
