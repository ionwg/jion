package org.ionwg.jion;

import java.util.List;

public interface Link extends IonObject {

    String getHref();

    String getMethod();

    List<String> getRelations();

    List<String> getExplicitRelations();

    String getImplicitRelation();
}
