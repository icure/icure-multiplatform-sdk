package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Named
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class PlanOfAction(
  override val id: String,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  public val prescriberId: String? = null,
  public val valueDate: Long? = null,
  public val openingDate: Long? = null,
  public val closingDate: Long? = null,
  public val deadlineDate: Long? = null,
  override val name: String? = null,
  public val descr: String? = null,
  public val note: String? = null,
  public val idOpeningContact: String? = null,
  public val idClosingContact: String? = null,
  public val status: Int = 0,
  public val documentIds: Set<String> = emptySet(),
  public val numberOfCares: Int? = null,
  public val careTeamMemberships: List<CareTeamMembership?> = emptyList(),
  public val relevant: Boolean = true,
  override val encryptedSelf: String? = null,
) : Encrypted, ICureDocument<String>, Named
