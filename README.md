# UniConnect — Integrated Campus Super App

UniConnect is a native Android campus super app built with Kotlin and Jetpack Compose.

## Sprint workflow

Each sprint is developed on its own branch and merged to `main` only after:

1. Implementation is complete.
2. Build, lint, and tests pass.
3. Architecture, security, UX, and maintainability are reviewed.
4. Any failure is debugged and revalidated.
5. A pull request is reviewed and merged.

## Sprint 1 — Foundation

The foundation is intentionally kept in one sprint:

```
SPRINT 1 — FOUNDATION
├── Android Project
├── Architecture
├── Design System
├── Navigation
├── Dependency Injection
└── Base Components
```

Current work is on `sprint/01-foundation`.

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

## Design system

UniConnect uses a brand-first Material 3 design system so every campus feature can share the same visual language.

### Tokens

- **Color** — branded blue, semantic success/warning/error/info colors, and neutral light/dark surfaces.
- **Typography** — consistent display, headline, title, body, and label hierarchy.
- **Shape** — reusable corner-radius scale from compact controls to large cards.
- **Spacing** — centralized 4dp-based spacing tokens.
- **Theme** — dedicated light and dark palettes with the same brand identity.

### Reusable components

The component foundation includes:

- Primary, secondary, text, and danger buttons.
- Standard application cards.
- Consistent outlined text fields.
- Semantic status chips.
- Loading state.
- Empty state.
- Section cards built on the shared card system.
- Existing bottom navigation foundation.

Components live under `ui/components` and theme tokens under `ui/theme`.

The theme currently follows the device light/dark setting. A user-controlled theme preference can be added later without changing component APIs.

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
