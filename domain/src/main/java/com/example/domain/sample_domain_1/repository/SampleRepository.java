package com.example.domain.sample_domain_1.repository;

import com.example.domain.sample_domain_1.model.SampleAggregate;
import java.util.Optional;

public interface SampleRepository {
    Optional<SampleAggregate> findById(String id);
    SampleAggregate save(SampleAggregate aggregate);
}
