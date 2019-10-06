package ru.tretyakov.data.models;

import javax.xml.bind.Unmarshaller;

/**
 * @author A.Tretyakov.
 * @since 04.10.19
 */
public class ElementLestener extends Unmarshaller.Listener {

    @Override
    public void afterUnmarshal(Object target, Object parent) {
        if (parent instanceof Box) {
            ((Element) target).setContained_in(((Box) parent).getId());
        }
    }
}
