package com.example.domain.sample_domain_1.model;

import com.example.sharedkernel.guard.Guard;
import com.example.sharedkernel.types.EmailAddress;

public final class SampleAggregate {
    private final String id;
    private EmailAddress email;

    public SampleAggregate(String id, EmailAddress email) {
        this.id = Guard.notBlank(id, "id");
        this.email = Guard.notNull(email, "email");
    }

    public String id() { return id; }
    public EmailAddress email() { return email; }
    public void changeEmail(EmailAddress newEmail) { this.email = Guard.notNull(newEmail, "newEmail"); }
}
