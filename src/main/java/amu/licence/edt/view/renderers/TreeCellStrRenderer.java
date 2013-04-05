package amu.licence.edt.view.renderers;

import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class TreeCellStrRenderer extends DefaultTreeCellRenderer {
    private static final long serialVersionUID = 1L;

    StrRenderer r;

    public TreeCellStrRenderer(StrRenderer r) {
        super();
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
