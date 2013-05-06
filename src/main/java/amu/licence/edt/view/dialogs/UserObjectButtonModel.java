package amu.licence.edt.view.dialogs;

import javax.swing.DefaultButtonModel;

public class UserObjectButtonModel <T> extends DefaultButtonModel {
    private static final long serialVersionUID = 1L;

    private T userObject;

    public UserObjectButtonModel(T userObject) {
        super();
        this.userObject = userObject;
    }

    public T getUserObject() {
        return userObject;
    }

    public void setUserObject(T userObject) {
        this.userObject = userObject;
    }

}
