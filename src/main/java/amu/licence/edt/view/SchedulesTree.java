package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;

import amu.licence.edt.presenter.Presenter;

public class SchedulesTree extends ViewComponent {

    public SchedulesTree(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        JTree tree;

        TreeNode rootNode = presenter.scheduleTreeCreating();
        tree = new JTree(rootNode);
        tree.setRootVisible(true);

        return tree;
    }

}
