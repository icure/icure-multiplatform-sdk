package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Encrypted
import com.icure.sdk.model.embed.TypedValue
import kotlin.Any
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Property(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val type: PropertyType? = null,
  public val typedValue: TypedValue<Any?>? = null,
  override val encryptedSelf: String? = null,
) : StoredDocument, Encrypted
