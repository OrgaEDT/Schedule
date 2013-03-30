package amu.licence.edt.view.renderers;

import amu.licence.edt.model.beans.Teacher;

public class TeacherRenderer implements Renderer {

    @Override
    public String getStrRender(Object obj) {
        try {
            Teacher teacher = (Teacher) obj;
            return teacher.getName();
        } catch (ClassCastException cce) {
            System.err.println("error: trying to render a non-Teacher in TeacherRenderer");
            return null;
        }
    }

}
