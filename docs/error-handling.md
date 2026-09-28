# Error Handling

UniConnect keeps network failures typed and predictable.

## Policy

- 2xx responses become NetworkResult.Success.
- HTTP failures become HttpError.
- connectivity failures become NetworkError.
- transient HTTP failures (408, 429, 5xx) and connectivity failures are retried with bounded exponential backoff.
- client errors such as 400 are not retried.
- retries are capped at three attempts by default.
- academic sync preserves the Room cache when a remote resource fails.

## Scope

This sprint does not add automatic background retry scheduling. WorkManager/background refresh remains a later production concern.
