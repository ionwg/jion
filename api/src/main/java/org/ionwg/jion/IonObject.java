package org.ionwg.jion;

import java.util.Map;

public interface IonObject extends Map<String,Object> {

    Map<String,Object> getMeta();
}
