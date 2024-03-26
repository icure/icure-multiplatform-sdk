package com.icure.sdk.model

import com.icure.sdk.model.base.Principal
import com.icure.sdk.model.base.StoredDocument
import kotlin.Long
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class Role(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val name: String? = null,
  public val permissions: Set<String> = emptySet(),
) : StoredDocument, Principal {
  override val properties: Set<PropertyStub> = emptySet()
}
