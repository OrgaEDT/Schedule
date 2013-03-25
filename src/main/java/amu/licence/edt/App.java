package amu.licence.edt;

import amu.licence.edt.controller.Controller;
import amu.licence.edt.model.Model;
import amu.licence.edt.presenter.Presenter;

public class App {

    public static void main( String[] args ) {
        Model model = new Model();
        Controller controller = new Controller(model);
        Presenter presenter = new Presenter(controller);
        presenter.getMainFrame().getFrame().setVisible(true);
    }

}
