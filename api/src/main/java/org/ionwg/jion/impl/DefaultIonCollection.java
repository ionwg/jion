package org.ionwg.jion.impl;

import org.ionwg.jion.IonCollection;
import org.ionwg.jion.lang.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultIonCollection<T> extends DefaultIonObject implements IonCollection<T> {

    public static final String ITEMS = "items";

    private final List<T> items;

    @SuppressWarnings("unchecked")
    public DefaultIonCollection(Map<String, Object> map) {
        super(map);
        Assert.isTrue(isIonCollection(map), "Ion Collections must have a 'meta' object and an 'items' array.");

        this.items = (List<T>)map.get(ITEMS);
    }

    @Override
    public List<T> getItems() {
        return this.items;
    }

    @Override
    public Iterator<T> iterator() {
        return this.items.iterator();
    }

    public static boolean isIonCollection(Map<String,Object> map) {
        if (isIonObject(map)) {
            Object value = map.get(ITEMS);
            return value instanceof List;
        }
        return false;
    }
}
