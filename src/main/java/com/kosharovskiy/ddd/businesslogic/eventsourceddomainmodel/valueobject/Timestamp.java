package com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject;

import java.time.ZonedDateTime;

public record Timestamp(ZonedDateTime timestamp) {
    public static Timestamp now() {
        return new Timestamp(ZonedDateTime.now());
    }

    public static Timestamp of(ZonedDateTime timestamp) {
        if (timestamp == null) {
            throw new IllegalArgumentException("Timestamp cannot be null");
        }

        return new Timestamp(timestamp);
    }
}
