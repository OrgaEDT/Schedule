package amu.licence.edt.view;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreeSelectionModel;

import amu.licence.edt.model.beans.CRoom;
import amu.licence.edt.model.beans.CRoomType;
import amu.licence.edt.model.beans.Group;
import amu.licence.edt.model.beans.Level;
import amu.licence.edt.model.beans.Teacher;
import amu.licence.edt.presenter.Presenter;
import amu.licence.edt.view.cell_renderers.CRoomTreeCellRenderer;
import amu.licence.edt.view.cell_renderers.CRoomTypeTreeCellRenderer;
import amu.licence.edt.view.cell_renderers.ClassBasedTreeCellDDR;
import amu.licence.edt.view.cell_renderers.GroupTreeCellRenderer;
import amu.licence.edt.view.cell_renderers.LevelTreeCellRenderer;
import amu.licence.edt.view.cell_renderers.TeacherTreeCellRenderer;

public class SchedulesTree extends ViewComponent {

    public SchedulesTree(Presenter presenter) {
        super(presenter);
    }

    @Override
    protected JComponent createComponent() {
        JTree tree;

        TreeNode rootNode = presenter.scheduleTreeCreating();
        tree = new JTree(rootNode);

        ClassBasedTreeCellDDR displayDelegationRenderer = new ClassBasedTreeCellDDR();
        displayDelegationRenderer.addRenderer(Teacher.class, new TeacherTreeCellRenderer());
        displayDelegationRenderer.addRenderer(Level.class, new LevelTreeCellRenderer());
        displayDelegationRenderer.addRenderer(CRoom.class, new CRoomTreeCellRenderer());
        displayDelegationRenderer.addRenderer(Group.class, new GroupTreeCellRenderer());
        displayDelegationRenderer.addRenderer(CRoomType.class, new CRoomTypeTreeCellRenderer());

        tree.setCellRenderer(displayDelegationRenderer);
        tree.setRootVisible(true);

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
