package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifiable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class Annotation(
  override val id: String,
  public val author: String? = null,
  public val created: Long? = null,
  public val modified: Long? = null,
  public val text: String? = null,
  public val markdown: Map<String, String> = emptyMap(),
  public val location: String? = null,
  public val confidential: Boolean? = null,
  public val tags: Set<CodeStub> = emptySet(),
  public val encryptedSelf: String? = null,
) : Identifiable<String>
