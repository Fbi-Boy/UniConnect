# Academic Sync

UniConnect uses an offline-first read strategy for academic data.

## Flow
1. AcademicSyncManager requests schedules, attendance, grades, KRS, assignments, and announcements from Retrofit concurrently.
2. A non-empty successful response replaces that resource's Room cache transactionally.
3. An empty remote response is treated as EmptyRemote and never clears existing local data.
4. HTTP or connectivity failures leave the existing Room cache untouched.
5. Partial success is allowed: successful resources are updated while failed resources keep their previous cache.
6. A sync metadata row records the last attempt and the last fully successful sync timestamp.

## Cache replacement
Each academic DAO exposes a transactional replaceAll operation. This prevents stale records from remaining when the server removes records while keeping each resource update atomic.

## Sync timestamps
academic_sync_metadata stores lastAttemptAtEpochMillis and lastSuccessfulAtEpochMillis.
The successful timestamp changes only when all six resources complete without an HTTP or connectivity failure.

## Background work
The current implementation does not schedule background work. A later production step can trigger AcademicSyncManager.sync() from an application-level refresh policy or WorkManager.

## Backend requirement
The Retrofit base URL remains a placeholder until the real campus backend is deployed. Sync tests use fake remote sources and do not require network access.
