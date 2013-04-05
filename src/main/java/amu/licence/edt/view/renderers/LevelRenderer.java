package amu.licence.edt.view.renderers;

import amu.licence.edt.model.beans.Level;

public class LevelRenderer implements StrRenderer {

    @Override
    public String getStrRender(Object obj) {
        try {
            Level level = (Level) obj;
            return level.getCode();
        } catch (ClassCastException cce) {
            System.err.println("error: trying to render a non-Level in LevelRenderer");
            return null;
        }
    }

}
