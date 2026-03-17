package com.example.infra.messaging.kafka;

import com.example.application.port.output.messaging.DomainEventPublisher;
import com.example.sharedkernel.domain.DomainEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class KafkaDomainEventPublisher implements DomainEventPublisher {
    private static final Logger log = LoggerFactory.getLogger(KafkaDomainEventPublisher.class);
    public void publish(DomainEvent event) { log.info("publishing event {}", event); }
}
