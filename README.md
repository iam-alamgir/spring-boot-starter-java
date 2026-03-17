# Spring Boot Starter Java Template

A DDD-first, test-first starter template using Java 25, Spring Boot 4, WebFlux, and Maven multi-module structure.

## Modules
- `shared-kernel`: framework-free primitives and value objects.
- `domain`: aggregates, repositories, events, and domain services.
- `application`: use-cases and ports.
- `infra/*`: adapters for persistence, messaging, and external systems.
- `interfaces/*`: REST and messaging entry points.
- `boot`: composition root, profiles, OpenTelemetry and Liquibase resources.

## Run
```bash
mvn clean verify
```

## Architectural Rules
- Dependency direction is enforced by module graph (outer depends on inner).
- Controllers and consumers delegate to input ports only.
- Infrastructure modules implement output ports only.

## OpenAPI-first
Specification is maintained at:
- `boot/src/main/resources/openapi/openapi.yaml`

## Coverage
JaCoCo fails build when line coverage is below 90%.

## Rename Script
Use `scripts/rename-template.sh` to update group/artifact/project/package names.
