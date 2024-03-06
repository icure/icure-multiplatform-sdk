package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.ICureDocument
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class SubContact(
  override val id: String? = null,
  override val created: Long? = null,
  override val modified: Long? = null,
  override val author: String? = null,
  override val responsible: String? = null,
  override val medicalLocationId: String? = null,
  override val tags: Set<CodeStub> = emptySet(),
  override val codes: Set<CodeStub> = emptySet(),
  override val endOfLife: Long? = null,
  public val descr: String? = null,
  public val protocol: String? = null,
  public val status: Int? = null,
  public val formId: String? = null,
  public val planOfActionId: String? = null,
  public val healthElementId: String? = null,
  public val classificationId: String? = null,
  public val services: List<ServiceLink> = emptyList(),
  override val encryptedSelf: String? = null,
) : Encrypted, ICureDocument<String?>
