# Session Security

The Android client has an explicit session boundary.

## Current implementation

- SessionToken models the access token and optional expiry.
- SessionStore isolates token storage from the rest of the app.
- SessionManager validates expiry and clears expired sessions.
- AuthenticatedApiCall converts missing or expired sessions to HTTP 401 semantics and clears the session after a server-side 401.
- The current store is intentionally in-memory and does not persist credentials to disk.

## Production requirement

Before production release, replace InMemorySessionStore with encrypted persistent storage backed by Android Keystore or an equivalent platform-secure mechanism. Access/refresh token rotation and backend-issued expiry claims belong to the real authentication API integration.

Passwords must never be stored in the Android client. The existing demo authentication repository is a temporary local foundation and is not a production authentication mechanism.
