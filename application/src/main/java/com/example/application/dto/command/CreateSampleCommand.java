package com.example.application.dto.command;

import com.example.sharedkernel.guard.Guard;

public record CreateSampleCommand(String id, String email) {
    public CreateSampleCommand {
        Guard.notBlank(id, "id");
        Guard.notBlank(email, "email");
    }
}
