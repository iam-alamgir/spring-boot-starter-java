package com.example.application.port.output.messaging;

import com.example.sharedkernel.domain.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
