package amu.licence.edt.view.main;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.ViewComponent;
import amu.licence.edt.view.renderers.ClassBasedTreeCellDDR;
import amu.licence.edt.view.renderers.DMTNUserObjectBasedRenderer;

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

        ClassBasedTreeCellDDR renderer = new ClassBasedTreeCellDDR(new DMTNUserObjectBasedRenderer(presenter.getClassBasedDDR()));
        tree.setCellRenderer(renderer);

        tree.getSelectionModel().setSelectionMode (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                presenter.treePathChanged(e.getPath());
            }
        });

        return tree;
    }

}
