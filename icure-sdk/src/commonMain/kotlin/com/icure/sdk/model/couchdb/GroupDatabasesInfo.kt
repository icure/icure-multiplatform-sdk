package com.icure.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class GroupDatabasesInfo(
    public val groupId: String,
    public val databasesInfo: List<DatabaseInfo> = emptyList(),
    public val gcpStorageSize: Long,
) {
    // region GroupDatabasesInfo-GroupDatabasesInfo

    // endregion
}
