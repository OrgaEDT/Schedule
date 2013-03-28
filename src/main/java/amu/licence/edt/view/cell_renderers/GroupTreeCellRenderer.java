package amu.licence.edt.view.cell_renderers;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

import amu.licence.edt.model.beans.Group;

public class GroupTreeCellRenderer extends DefaultTreeCellRenderer {
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
            boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        Group g = (Group) value;
        setText(g.getId()+"");  // maby we could find a better looking id for groups

        return this;
    }
}
