package com.example.domain.sample_domain_1.event;

import com.example.sharedkernel.domain.DomainEvent;
import java.time.Instant;

public record SampleCreatedEvent(String aggregateId, Instant occurredAt) implements DomainEvent {}
