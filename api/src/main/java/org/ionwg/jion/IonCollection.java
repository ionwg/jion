package org.ionwg.jion;

import java.util.List;

public interface IonCollection<T> extends IonObject, Iterable<T> {

    List<T> getItems();
}
