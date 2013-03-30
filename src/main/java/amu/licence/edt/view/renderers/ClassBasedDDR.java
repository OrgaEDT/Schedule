package amu.licence.edt.view.renderers;

import java.util.HashMap;
import java.util.Map;

public class ClassBasedDDR implements Renderer {

    protected Map<Class<?>, Renderer> renderers;

    public ClassBasedDDR() {
        this.renderers = new HashMap<Class<?>, Renderer>();
    }

    @Override
    public String getStrRender(Object obj) {

        // /!\ inheritance not handled, specific class only
        Renderer r;
        if (obj == null || (r = renderers.get(obj.getClass())) == null) {
            return obj.toString();
        }

        return r.getStrRender(obj);
    }

    public void addRenderer(Class<?> clazz, Renderer renderer) {
        renderers.put(clazz, renderer);
    }

    public void removeRenderer(Class<?> clazz) {
        renderers.remove(clazz);
    }
}
