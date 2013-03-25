package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JTree;

import amu.licence.edt.presenter.Presenter;

public class SchedulesTree extends ViewComponent {

    public SchedulesTree(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        return new JTree();
    }

}
