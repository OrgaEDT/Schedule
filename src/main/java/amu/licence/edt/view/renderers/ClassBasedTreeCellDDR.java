package amu.licence.edt.view.renderers;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/*
 * Class Based Tree Cell Display Delegation Renderer
 */
public class ClassBasedTreeCellDDR extends DefaultTreeCellRenderer implements TreeCellRenderer {
    private static final long serialVersionUID = 1L;

    Renderer r;

    public ClassBasedTreeCellDDR(Renderer r) {
        this.r = r;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        setText(r.getStrRender(value));
        return this;
    }

}
