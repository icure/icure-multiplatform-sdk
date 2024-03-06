package com.icure.sdk.model

import com.icure.sdk.model.base.Principal
import com.icure.sdk.model.base.StoredDocument
import kotlin.Cloneable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Role(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val name: String? = null,
  public val permissions: Set<String> = emptySet(),
) : StoredDocument, Principal, Cloneable, IoSerializable
