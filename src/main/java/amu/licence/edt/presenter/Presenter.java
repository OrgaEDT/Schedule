package amu.licence.edt.presenter;

import amu.licence.edt.controller.Controller;
import amu.licence.edt.view.View;

public class Presenter {

    private View view;
    private Controller controller;

    public Presenter(Controller controller) {
        this.view = new View(this);
        this.controller = controller;
    }

    public void showView() {
        view.getMainFrame().getFrame().setVisible(true);
    }

}
