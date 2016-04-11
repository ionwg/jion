package org.ionwg.jion;

import java.util.Map;

public interface Field<T> extends Map<String,Object> {

    boolean isEnabled();

    T getMin();

    T getMax();

    T getValue();

    String getName();

    String getPattern();

    String getPlaceholder();

    String getLabel();

    boolean isMutable();

    boolean isRequired();

    boolean isVisible();

    FieldType getType();

}
