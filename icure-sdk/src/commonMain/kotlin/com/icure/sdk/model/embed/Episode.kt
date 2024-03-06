package com.icure.sdk.model.embed

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.base.Named
import kotlin.Long
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Episode(
  override val id: String,
  override val name: String? = null,
  public val comment: String? = null,
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  override val encryptedSelf: String? = null,
) : Encrypted, IoSerializable, Identifiable<String>, Named
