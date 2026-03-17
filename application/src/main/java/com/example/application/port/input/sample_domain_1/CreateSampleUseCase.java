package com.example.application.port.input.sample_domain_1;

import com.example.application.dto.command.CreateSampleCommand;
import com.example.application.dto.result.SampleResult;

public interface CreateSampleUseCase {
    SampleResult handle(CreateSampleCommand command);
}
