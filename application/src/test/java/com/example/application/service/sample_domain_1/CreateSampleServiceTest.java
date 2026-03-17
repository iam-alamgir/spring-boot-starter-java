package com.example.application.service.sample_domain_1;

import com.example.application.dto.command.CreateSampleCommand;
import com.example.application.port.output.messaging.DomainEventPublisher;
import com.example.domain.sample_domain_1.model.SampleAggregate;
import com.example.domain.sample_domain_1.repository.SampleRepository;
import com.example.sharedkernel.types.EmailAddress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateSampleServiceTest {
    @Mock SampleRepository repository;
    @Mock DomainEventPublisher publisher;
    @InjectMocks CreateSampleService service;

    @Test
    void givenValidCommand_whenHandle_thenSavesAndPublishes() {
        when(repository.save(any())).thenReturn(new SampleAggregate("id-1", new EmailAddress("x@y.com")));

        var result = service.handle(new CreateSampleCommand("id-1", "x@y.com"));

        assertEquals("id-1", result.id());
        verify(repository).save(any());
        verify(publisher).publish(any());
    }
}
