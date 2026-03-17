package com.example.sharedkernel.types;

import java.time.LocalDate;

public record DateRange(LocalDate start, LocalDate end) {
    public DateRange {
        if (start == null || end == null || end.isBefore(start)) throw new IllegalArgumentException("invalid range");
    }
}
