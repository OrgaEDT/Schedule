package amu.licence.edt.view.renderers;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ClassBasedCbbListDDR extends DefaultListCellRenderer {
    private static final long serialVersionUID = 1L;

    Renderer r;

    public ClassBasedCbbListDDR(Renderer r) {
        super();
        this.r = r;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        setText(r.getStrRender(value));
        return this;
    }

}
