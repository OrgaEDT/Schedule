package amu.licence.edt.view.renderers;

import amu.licence.edt.model.beans.CRoom;

public class CRoomRenderer implements Renderer {

    @Override
    public String getStrRender(Object obj) {
        try {
            CRoom croom = (CRoom) obj;
            return croom.getNum();
        } catch (ClassCastException cce) {
            System.err.println("error: trying to render a non-CRoom in CRoomRenderer");
            return null;
        }
    }

}
