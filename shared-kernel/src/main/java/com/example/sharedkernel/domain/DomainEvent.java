package com.example.sharedkernel.domain;

import java.time.Instant;

public interface DomainEvent {
    Instant occurredAt();
}
