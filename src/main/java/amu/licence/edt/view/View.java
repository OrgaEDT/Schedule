package amu.licence.edt.view;

import amu.licence.edt.presenter.Presenter;

public class View extends AbstractView {

    private MainFrame mainFrame;

    public View(Presenter presenter) {
        super(presenter);
        mainFrame = new MainFrame(presenter);
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

}
