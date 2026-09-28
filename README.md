# UniConnect — Integrated Campus Super App

UniConnect is a native Android campus super app built with Kotlin and Jetpack Compose.

## Sprint workflow

Each sprint is developed on its own branch and merged to `main` only after:

1. Implementation is complete.
2. Build, lint, and tests pass.
3. Architecture, security, UX, and maintainability are reviewed.
4. Any failure is debugged and revalidated.
5. A pull request is reviewed and merged.

## Architecture

```
Compose UI
    ↓
ViewModel + StateFlow
    ↓
Use Case
    ↓
Domain Repository Contract
    ↓
Data Repository Implementation
    ↓
Local / Remote Data Source
```

The project uses pragmatic Clean Architecture: presentation, domain, and data responsibilities are separated without unnecessary boilerplate.

### Layers

- **Presentation** — Compose screens and ViewModels.
- **Domain** — business models, repository contracts, and use cases.
- **Data** — DTO/data models, mappers, repository implementations, and data sources.
- **DI** — Hilt modules that bind abstractions to implementations.
- **Core** — shared infrastructure such as navigation, networking, database, and security as they are introduced.

### Current vertical slice

The student dashboard already demonstrates the complete dependency direction:

`StudentLocalDataSource → StudentRepositoryImpl → GetCurrentStudentUseCase → StudentViewModel → DashboardScreen`

The UI does not depend directly on the concrete data source.

## Current stack

- Kotlin 2.0.21
- Android Gradle Plugin 8.7.3
- Jetpack Compose + Material 3
- Navigation Compose
- ViewModel + StateFlow
- Hilt
- Gradle 8.9
- JDK 17
- JUnit

## Planned data stack

- Room for local persistence
- Retrofit for REST API integration
- Secure token/session handling
- Coroutines + Flow for asynchronous data
- Unit and UI testing

## Development standard

Features are delivered as vertical slices. A completed slice should be runnable, testable, and maintainable before moving to the next sprint.
