# UniConnect Room Database

UniConnectDatabase is the local persistence boundary for cached campus data.

## Schema strategy

- Current schema version: **1**.
- The database does not use destructive fallback.
- Any future schema change must increment the Room version and add an explicit Migration.
- Migrations should preserve user data and be covered by a database/instrumentation test when the affected schema is introduced.
- Domain models remain independent from Room entities; mapping is isolated in RoomMappers.kt.

The current seed behavior keeps the existing demo experience: a local data source reads Room first and inserts the existing demo records only when its table is empty.
