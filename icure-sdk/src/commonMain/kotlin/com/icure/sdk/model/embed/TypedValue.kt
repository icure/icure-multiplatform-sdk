package com.icure.sdk.model.embed

import java.time.Instant
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.constants.TypedValuesType

@Serializable
public data class TypedValue<T>(
  public val type: TypedValuesType? = null,
  public val booleanValue: Boolean? = null,
  public val integerValue: Long? = null,
  public val doubleValue: Double? = null,
  public val stringValue: String? = null,
  public val dateValue: Instant? = null,
  override val encryptedSelf: String? = null,
) : Comparable<TypedValue<T>>, Encrypted
