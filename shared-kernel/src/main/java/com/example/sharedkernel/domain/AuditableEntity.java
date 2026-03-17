package com.example.sharedkernel.domain;

import java.time.Instant;

public abstract class AuditableEntity {
    private final Instant createdAt = Instant.now();
    public Instant createdAt() { return createdAt; }
}
