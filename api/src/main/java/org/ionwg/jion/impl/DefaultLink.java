package org.ionwg.jion.impl;

import org.ionwg.jion.Link;
import org.ionwg.jion.lang.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DefaultLink extends DefaultIonObject implements Link {

    public static final String HREF = "href";
    public static final String METHOD = "method";
    public static final String REL = "rel";

    private final String implicitRelation;
    private final List<String> explicitRelations;
    private final List<String> relations;

    public DefaultLink(Map<String, Object> map, String implicitRelation) {

        super(map);

        Assert.isTrue(isLink(map), "Ion Links must have a 'meta' object that contains an 'href' string.");

        Assert.hasText(implicitRelation, "implicitRelation argument cannot be null.");
        this.implicitRelation = implicitRelation;

        List<String> relations = new ArrayList<>();
        List<String> explicitRelations = java.util.Collections.emptyList();

        Object rel = map.get(REL);
        if (rel != null) {
            Assert.isInstanceOf(List.class, rel, "Link rel must be a List of Strings");
            List list = (List)rel;
            int size = list.size();
            if (size > 0) {
                explicitRelations = new ArrayList<>(size);
            }
            for(Object element : list) {
                Assert.isInstanceOf(String.class, element, "Link rel must be a List of Strings");
                String relation = (String)element;
                explicitRelations.add(relation);
                relations.add(relation);
            }
        }

        relations.add(implicitRelation);

        this.explicitRelations = explicitRelations;
        this.relations = relations;
    }

    @Override
    public String getHref() {
        return getString(HREF);
    }

    @Override
    public String getMethod() {
        return getString(METHOD);
    }

    @Override
    public List<String> getRelations() {
        return this.relations;
    }

    @Override
    public List<String> getExplicitRelations() {
        return this.explicitRelations;
    }

    @Override
    public String getImplicitRelation() {
        return this.implicitRelation;
    }

    @SuppressWarnings("unchecked")
    public static boolean isLink(Map map) {
        if (isIonObject(map)) {
            Map<String,Object> meta = (Map<String,Object>)map.get(META);
            Object value = meta.get(HREF);
            return value instanceof String;
        }
        return false;
    }
}
