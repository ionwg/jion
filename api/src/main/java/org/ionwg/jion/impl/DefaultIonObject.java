package org.ionwg.jion.impl;

import org.ionwg.jion.IonObject;
import org.ionwg.jion.lang.Assert;

import java.util.Map;

public class DefaultIonObject extends IonMap implements IonObject {

    public static final String META = "meta";

    private final Map<String, Object> meta;

    @SuppressWarnings("unchecked")
    public DefaultIonObject(Map<String, Object> map) {
        super(map);
        Assert.isTrue(isIonObject(map), "Ion objects must contain a non-empty 'meta' object.");
        this.meta = (Map<String,Object>)map.get(META);
    }

    public static boolean isIonObject(Map map) {
        if (map != null) {
            Object value = map.get(META);
            return value != null && value instanceof Map && !(((Map) value).isEmpty());
        }
        return false;
    }

    @Override
    public Map<String, Object> getMeta() {
        return this.meta;
    }
}
