package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import org.taktik.icure.constants.TypedValuesType

@Serializable
public sealed interface TypedValue<T> : Encrypted {
  public val type: TypedValuesType?

  public val booleanValue: Boolean?

  public val integerValue: Long?

  public val doubleValue: Double?

  public val stringValue: String?

  public val dateValue: Instant?

  override val encryptedSelf: String?
}

public data class DecryptedTypedValue(
  override val type: TypedValuesType? = null,
  override val booleanValue: Boolean? = null,
  override val integerValue: Long? = null,
  override val doubleValue: Double? = null,
  override val stringValue: String? = null,
  @Serializable(with = icure.sdk.serialization.InstantSerializer::class)
  override val dateValue: Instant? = null,
  override val encryptedSelf: String? = null,
) : TypedValue

public data class EncryptedTypedValue(
  override val type: TypedValuesType? = null,
  override val booleanValue: Boolean? = null,
  override val integerValue: Long? = null,
  override val doubleValue: Double? = null,
  override val stringValue: String? = null,
  @Serializable(with = icure.sdk.serialization.InstantSerializer::class)
  override val dateValue: Instant? = null,
  override val encryptedSelf: String? = null,
) : TypedValue

public fun TypedValue.copy(
  type: TypedValuesType? = this.type,
  booleanValue: Boolean? = this.booleanValue,
  integerValue: Long? = this.integerValue,
  doubleValue: Double? = this.doubleValue,
  stringValue: String? = this.stringValue,
  dateValue: Instant? = this.dateValue,
  encryptedSelf: String? = this.encryptedSelf,
): TypedValue {
                                      return when(this) {
                                          is DecryptedTypedValue -> copy(type = type, booleanValue =
          booleanValue, integerValue = integerValue, doubleValue = doubleValue, stringValue =
          stringValue, dateValue = dateValue, encryptedSelf = encryptedSelf)
      is EncryptedTypedValue -> copy(type = type, booleanValue = booleanValue, integerValue =
          integerValue, doubleValue = doubleValue, stringValue = stringValue, dateValue = dateValue,
          encryptedSelf = encryptedSelf)
                                          }
}
