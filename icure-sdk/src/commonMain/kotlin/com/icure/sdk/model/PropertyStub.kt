package com.icure.sdk.model

import com.icure.sdk.model.embed.Encrypted
import com.icure.sdk.model.embed.TypedValue
import kotlin.Any
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PropertyStub(
  public val id: String? = null,
  public val type: PropertyTypeStub? = null,
  public val typedValue: TypedValue<Any?>? = null,
  public val deletionDate: Long? = null,
  override val encryptedSelf: String? = null,
) : Encrypted
