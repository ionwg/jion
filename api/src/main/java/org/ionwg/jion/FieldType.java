package org.ionwg.jion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.*;

public enum FieldType {

    BOOLEAN(Boolean.class),

    DATE(LocalDate.class),

    DATETIME(LocalDateTime.class),

    DATETIMETZ(ZonedDateTime.class),

    DECIMAL(BigDecimal.class),

    EMAIL(String.class),

    INTEGER(BigInteger.class),

    NUMBER(BigDecimal.class),

    PASSWORD(String.class),

    STRING(String.class),

    TIME(LocalTime.class),

    TIMETZ(OffsetTime.class);

    private final Class javaClass;

    FieldType(Class javaClass) {
        this.javaClass = javaClass;
    }
}
