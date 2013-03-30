package amu.licence.edt.view.renderers;

import javax.swing.tree.DefaultMutableTreeNode;

/*
 * Default Mutable Tree Node User Object Based Renderer
 */
public class DMTNUserObjectBasedRenderer extends ClassBasedDDR implements Renderer {

    public DMTNUserObjectBasedRenderer(ClassBasedDDR classBasedDDR) {
        this.renderers = classBasedDDR.renderers;
    }

    @Override
    public String getStrRender(Object obj) {
        try {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj;
            return super.getStrRender(node.getUserObject());
        } catch (ClassCastException cce) {
            System.err.println("error: trying to render a non-Group in GroupRenderer");
            return null;
        }
    }

}
