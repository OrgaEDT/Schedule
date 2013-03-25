package amu.licence.edt.presenter;

import amu.licence.edt.controller.Controller;
import amu.licence.edt.view.MainFrame;

public class Presenter {

    private MainFrame mainFrame;
    private Controller controller;

    public Presenter(Controller controller) {
        this.mainFrame = new MainFrame(this);
        this.controller = controller;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

}
