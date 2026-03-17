package com.example.domain.sample_domain_1.model;

import com.example.sharedkernel.types.EmailAddress;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleAggregateTest {
    @Test
    void givenAggregate_whenChangeEmail_thenStateChanges() {
        var aggregate = new SampleAggregate("id-1", new EmailAddress("old@ex.com"));
        aggregate.changeEmail(new EmailAddress("new@ex.com"));
        assertEquals("new@ex.com", aggregate.email().value());
    }
}
