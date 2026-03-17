package com.example.infra.persistence.sample_domain_1;

import com.example.domain.sample_domain_1.model.SampleAggregate;
import com.example.domain.sample_domain_1.repository.SampleRepository;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class SampleRepositoryAdapter implements SampleRepository {
    private final Map<String, SampleAggregate> store = new ConcurrentHashMap<>();
    public Optional<SampleAggregate> findById(String id) { return Optional.ofNullable(store.get(id)); }
    public SampleAggregate save(SampleAggregate aggregate) { store.put(aggregate.id(), aggregate); return aggregate; }
}
