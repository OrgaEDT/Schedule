package amu.licence.edt.controller;

import amu.licence.edt.model.Model;

public class Controller {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public boolean validateLoginRequested(String login, String password) {
        return model.tryToConnect(login, password);
    }

    public void disconnectionRequested() {
        model.disconnect();
    }

}
