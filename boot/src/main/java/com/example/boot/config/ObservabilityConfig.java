package com.example.boot.config;

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObservabilityConfig {
    @Bean
    Tracer tracer(OpenTelemetry openTelemetry) { return openTelemetry.getTracer("starter-template"); }
}
