package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.serialization.EntityTemplateSerializer
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable(with = EntityTemplateSerializer::class)
public data class EntityTemplate(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val userId: String? = null,
  public val descr: String? = null,
  public val keywords: Set<String>? = null,
  public val entityType: String? = null,
  public val subType: String? = null,
  public val defaultTemplate: Boolean? = null,
  public val entity: List<Map<String, Any>> = emptyList(),
) : StoredDocument
