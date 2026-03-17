package com.example.domain.sample_domain_1.factory;

import com.example.domain.sample_domain_1.model.SampleAggregate;
import com.example.sharedkernel.types.EmailAddress;

public final class SampleFactory {
    private SampleFactory() {}
    public static SampleAggregate create(String id, String email) { return new SampleAggregate(id, new EmailAddress(email)); }
}
