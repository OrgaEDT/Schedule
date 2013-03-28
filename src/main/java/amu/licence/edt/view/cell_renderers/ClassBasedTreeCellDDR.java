package amu.licence.edt.view.cell_renderers;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/*
 * Class Based Tree Cell Display Delegation Renderer
 */
public class ClassBasedTreeCellDDR implements TreeCellRenderer {

    private Map<Class<?>, TreeCellRenderer> renderers;
    private TreeCellRenderer defaultRenderer;

    public ClassBasedTreeCellDDR() {
        this.renderers = new HashMap<Class<?>, TreeCellRenderer>();
        this.defaultRenderer = new DefaultTreeCellRenderer();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        DefaultMutableTreeNode node = null;
        try {
            node = (DefaultMutableTreeNode) value;
        } catch (ClassCastException cce) {
            System.err.println("Object in tree is not a DefaultMutableTreeNode, cannot render properly");
        }

        // /!\ inheritance not handled, specific class only
        TreeCellRenderer r;
        if (value == null || (r = renderers.get(node.getUserObject().getClass())) == null) {
            r = defaultRenderer;
        }

        return r.getTreeCellRendererComponent(tree, node.getUserObject(), selected, expanded, leaf, row, hasFocus);
    }

    public void addRenderer(Class<?> clazz, TreeCellRenderer renderer) {
        renderers.put(clazz, renderer);
    }

    public void removeRenderer(Class<?> clazz) {
        renderers.remove(clazz);
    }

}
