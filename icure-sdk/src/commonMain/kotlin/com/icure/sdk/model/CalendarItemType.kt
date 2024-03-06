package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class CalendarItemType(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val name: String? = null,
  public val color: String? = null,
  public val duration: Int = 0,
  public val externalRef: String? = null,
  public val mikronoId: String? = null,
  public val docIds: Set<String> = emptySet(),
  public val otherInfos: Map<String, String> = emptyMap(),
  public val subjectByLanguage: Map<String, String> = emptyMap(),
) : StoredDocument
