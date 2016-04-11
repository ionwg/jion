package org.ionwg.jion;

import java.util.Map;

public interface FieldOption<T> extends Map<String,Object> {

    String getLabel();

    T getValue();

    boolean isSelected();

    boolean isEnabled();
}
