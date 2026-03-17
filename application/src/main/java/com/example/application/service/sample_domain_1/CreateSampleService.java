package com.example.application.service.sample_domain_1;

import com.example.application.dto.command.CreateSampleCommand;
import com.example.application.dto.result.SampleResult;
import com.example.application.port.input.sample_domain_1.CreateSampleUseCase;
import com.example.application.port.output.messaging.DomainEventPublisher;
import com.example.domain.sample_domain_1.event.SampleCreatedEvent;
import com.example.domain.sample_domain_1.factory.SampleFactory;
import com.example.domain.sample_domain_1.repository.SampleRepository;
import java.time.Instant;
import org.springframework.stereotype.Service;

@Service
public class CreateSampleService implements CreateSampleUseCase {
    private final SampleRepository repository;
    private final DomainEventPublisher publisher;

    public CreateSampleService(SampleRepository repository, DomainEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    @Override
    public SampleResult handle(CreateSampleCommand command) {
        var aggregate = SampleFactory.create(command.id(), command.email());
        var saved = repository.save(aggregate);
        publisher.publish(new SampleCreatedEvent(saved.id(), Instant.now()));
        return new SampleResult(saved.id(), saved.email().value());
    }
}
