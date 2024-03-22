package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.FrontEndMigrationStatus
import kotlin.Long
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class FrontEndMigration(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val name: String? = null,
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val status: FrontEndMigrationStatus? = null,
  public val logs: String? = null,
  public val userId: String? = null,
  public val startKey: String? = null,
  public val startKeyDocId: String? = null,
  public val processCount: Long? = null,
  public val properties: Set<PropertyStub> = emptySet(),
) : StoredDocument
