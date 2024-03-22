package com.icure.sdk.model.couchdb

import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class GroupDatabasesInfo(
  public val groupId: String,
  public val databasesInfo: List<DatabaseInfo> = emptyList(),
  public val gcpStorageSize: Long,
)
