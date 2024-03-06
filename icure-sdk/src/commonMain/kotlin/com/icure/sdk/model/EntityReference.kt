package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class EntityReference(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val docId: String? = null,
) : StoredDocument
