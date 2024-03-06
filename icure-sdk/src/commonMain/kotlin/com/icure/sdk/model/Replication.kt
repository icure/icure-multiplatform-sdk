package com.icure.sdk.model

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.base.Named
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DatabaseSynchronization
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Replication(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val name: String? = null,
  public val context: String? = null,
  public val databaseSynchronizations: List<DatabaseSynchronization> = emptyList(),
) : StoredDocument, Identifiable<String>, Named
