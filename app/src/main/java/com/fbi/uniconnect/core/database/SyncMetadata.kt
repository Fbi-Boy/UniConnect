package com.fbi.uniconnect.core.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "academic_sync_metadata")
data class AcademicSyncMetadataEntity(
    @PrimaryKey val id: String,
    val lastAttemptAtEpochMillis: Long,
    val lastSuccessfulAtEpochMillis: Long?,
)
