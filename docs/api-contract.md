# UniConnect API Contract

## Purpose

This document defines the Android client's typed contract for the future UniConnect backend. The Retrofit layer is ready for integration, but the current repository does not claim that these endpoints are deployed.

## Base URL

The Android client currently uses the placeholder:

`https://api.uniconnect.example/`

Replace it with the deployed backend URL during the backend/API deployment work. No production endpoint is hard-coded into feature code.

## Read endpoints

| Method | Endpoint | Response |
| --- | --- | --- |
| GET | `health` | `HealthResponse` |
| GET | `api/v1/schedules` | `List<ScheduleDto>` |
| GET | `api/v1/attendance` | `List<AttendanceDto>` |
| GET | `api/v1/grades` | `List<GradeDto>` |
| GET | `api/v1/krs` | `List<KrsDto>` |
| GET | `api/v1/assignments` | `List<AssignmentDto>` |
| GET | `api/v1/announcements` | `List<AnnouncementDto>` |

## Data boundaries

- Retrofit DTOs are isolated from Room entities and domain models.
- DTO-to-data-model mapping happens in the remote data layer.
- Room remains the local persistence/cache boundary.
- Schedule reads use the remote result when available and fall back to Room when the network is unavailable.
- An empty remote response does not erase an existing local cache.
- Backend authentication, token refresh, write endpoints, pagination, and server-side validation are intentionally deferred to the authentication/API backend sprint.

## Error handling

The Retrofit layer exposes transport failures as `NetworkResult` rather than leaking Retrofit exceptions into ViewModels. HTTP status failures are represented separately from connectivity failures.
