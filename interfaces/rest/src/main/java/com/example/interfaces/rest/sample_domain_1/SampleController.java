package com.example.interfaces.rest.sample_domain_1;

import com.example.application.dto.command.CreateSampleCommand;
import com.example.application.dto.result.SampleResult;
import com.example.application.port.input.sample_domain_1.CreateSampleUseCase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/samples")
public class SampleController {
    private final CreateSampleUseCase useCase;
    public SampleController(CreateSampleUseCase useCase) { this.useCase = useCase; }

    @PostMapping
    public Mono<SampleResponse> create(@RequestBody SampleRequest request) {
        SampleResult result = useCase.handle(new CreateSampleCommand(request.id(), request.email()));
        return Mono.just(new SampleResponse(result.id(), result.email()));
    }

    public record SampleRequest(@NotBlank String id, @Email String email) {}
    public record SampleResponse(String id, String email) {}
}
