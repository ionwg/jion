package org.ionwg.jion;

import java.util.List;
import java.util.Map;

public interface FieldOptions<T> extends Map<String,Object>, Iterable<FieldOption<T>> {

    boolean isMultiple();

    FieldOptionControl getControl();

    List<FieldOption<T>> getOptions();
}
