# UniConnect — Integrated Campus Super App

UniConnect is a native Android campus super app built with Kotlin and Jetpack Compose.

## Sprint workflow

Each sprint is developed on its own branch and merged to `main) only after:

1. Implementation is complete.
2. Build and lint pass.
3. Architecture, security, UX, and maintainability are reviewed.
4. Any failure is debugged and revalidated.
5. A pull request is reviewed and merged.

## Architecture direction

```
Presentation (Compose + ViewModel)
        ↓
Domain (Use Cases + Repository Contracts)
        ↓
Data (Repository Implementations)
     ↙       ↘
  Room     Retrofit
```

The project uses a pragmatic Clean Architecture approach: enough separation for maintainability without unnecessary boilerplate.

## Current stack

- Kotlin 2.0.21
- Android Gradle Plugin 8.7.3
- Jetpack Compose + Material 3
- Navigation Compose
- Gradle 8.9
- JDK 17

## Planned stack

- ViewModel + Coroutines + Flow
- Room for local persistence
- Retrofit for REST API integration
- Hilt for dependency injection
- Unit and UI testing
- Role-based student, lecturer, and admin experiences

## Development standard

Features are delivered as vertical slices. A completed slice should be runnable and testable before moving to the next one.
