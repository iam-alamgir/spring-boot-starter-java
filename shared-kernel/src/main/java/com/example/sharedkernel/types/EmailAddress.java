package com.example.sharedkernel.types;

import com.example.sharedkernel.guard.Guard;

public record EmailAddress(String value) {
    public EmailAddress {
        Guard.notBlank(value, "email");
        if (!value.contains("@")) throw new IllegalArgumentException("email must contain @");
    }
}
