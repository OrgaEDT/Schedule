package amu.licence.edt.view.renderers;

import javax.swing.tree.DefaultMutableTreeNode;

/*
 * Default Mutable Tree Node User Object Based String Renderer
 */
public class DMTNUserObjectBasedStrRenderer implements StrRenderer {

    private StrRenderer r;

    public DMTNUserObjectBasedStrRenderer(StrRenderer r) {
        this.r = r;
    }

    @Override
    public String getStrRender(Object obj) {
        try {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
            return r.getStrRender(node.getUserObject());
        } catch (ClassCastException cce) {
            System.err.println("error: trying to render a non-DefaultMutableTreeNode in DMTNUserObjectBasedStrRenderer");
            return null;
        }
    }

}
