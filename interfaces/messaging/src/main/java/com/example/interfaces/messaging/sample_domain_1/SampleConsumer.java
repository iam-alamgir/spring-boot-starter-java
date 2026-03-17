package com.example.interfaces.messaging.sample_domain_1;

import com.example.application.dto.command.CreateSampleCommand;
import com.example.application.port.input.sample_domain_1.CreateSampleUseCase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SampleConsumer {
    private final CreateSampleUseCase useCase;
    public SampleConsumer(CreateSampleUseCase useCase) { this.useCase = useCase; }
    @KafkaListener(topics = "sample-created")
    public void consume(Payload payload) { useCase.handle(new CreateSampleCommand(payload.id(), payload.email())); }
    public record Payload(String id, String email) {}
}
