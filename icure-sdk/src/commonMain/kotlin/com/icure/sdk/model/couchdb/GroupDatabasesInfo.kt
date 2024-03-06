package com.icure.sdk.model.couchdb

import kotlin.Long
import kotlin.String
import kotlin.collections.List
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class GroupDatabasesInfo(
  public val groupId: String,
  public val databasesInfo: List<DatabaseInfo> = emptyList(),
  public val gcpStorageSize: Long,
) : IoSerializable
