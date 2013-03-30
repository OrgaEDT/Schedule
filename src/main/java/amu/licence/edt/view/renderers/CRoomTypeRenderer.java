package amu.licence.edt.view.renderers;

import amu.licence.edt.model.beans.CRoomType;

public class CRoomTypeRenderer implements Renderer {

    @Override
    public String getStrRender(Object obj) {
        try {
            CRoomType crType = (CRoomType) obj;
            return crType.getLibel();
        } catch (ClassCastException cce) {
            System.err.println("error: trying to render a non-CRoomType in CRoomTypeRenderer");
            return null;
        }
    }

}
