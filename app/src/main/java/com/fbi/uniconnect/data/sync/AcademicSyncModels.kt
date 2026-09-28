package com.fbi.uniconnect.data.sync

import com.fbi.uniconnect.core.network.NetworkResult

enum class SyncResource {
    SCHEDULES,
    ATTENDANCE,
    GRADES,
    KRS,
    ASSIGNMENTS,
    ANNOUNCEMENTS,
}

sealed interface SyncResourceState {
    data object Updated : SyncResourceState
    data object EmptyRemote : SyncResourceState
    data class Failed(val result: NetworkResult<Nothing>) : SyncResourceState
}

data class AcademicSyncResult(
    val resources: Map<SyncResource, SyncResourceState>,
    val attemptedAtEpochMillis: Long,
    val completedAtEpochMillis: Long,
    val lastSuccessfulSyncAtEpochMillis: Long?,
) {
    val isFullySuccessful: Boolean
        get() = resources.values.all {
            it is SyncResourceState.Updated || it is SyncResourceState.EmptyRemote
        }

    val failedResources: List<SyncResource>
        get() = resources.filterValues { it is SyncResourceState.Failed }.keys.toList()
}
