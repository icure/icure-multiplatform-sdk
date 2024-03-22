package com.icure.sdk.model.embed

import com.icure.sdk.serialization.InstantSerializer
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.String
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface TypedValue<T> : Encrypted {
  public val type: TypedValuesType?

  public val booleanValue: Boolean?

  public val integerValue: Long?

  public val doubleValue: Double?

  public val stringValue: String?

  public val dateValue: Instant?

  override val encryptedSelf: String?
	// region TypedValue-TypedValue
	// endregion
}

data class DecryptedTypedValue<T>(
  override val type: TypedValuesType? = null,
  override val booleanValue: Boolean? = null,
  override val integerValue: Long? = null,
  override val doubleValue: Double? = null,
  override val stringValue: String? = null,
  @Serializable(with = InstantSerializer::class)
  override val dateValue: Instant? = null,
  override val encryptedSelf: String? = null,
) : TypedValue<T> {
	// region TypedValue-DecryptedTypedValue
	// endregion
}

data class EncryptedTypedValue<T>(
  override val type: TypedValuesType? = null,
  override val booleanValue: Boolean? = null,
  override val integerValue: Long? = null,
  override val doubleValue: Double? = null,
  override val stringValue: String? = null,
  @Serializable(with = InstantSerializer::class)
  override val dateValue: Instant? = null,
  override val encryptedSelf: String? = null,
) : TypedValue<T> {
	// region TypedValue-EncryptedTypedValue
	// endregion
}

public fun <T> TypedValue<T>.copy(
  type: TypedValuesType? = this.type,
  booleanValue: Boolean? = this.booleanValue,
  integerValue: Long? = this.integerValue,
  doubleValue: Double? = this.doubleValue,
  stringValue: String? = this.stringValue,
  dateValue: Instant? = this.dateValue,
  encryptedSelf: String? = this.encryptedSelf,
): TypedValue<T> {
                                      return when(this) {
                                          is DecryptedTypedValue -> copy(type = type, booleanValue =
          booleanValue, integerValue = integerValue, doubleValue = doubleValue, stringValue =
          stringValue, dateValue = dateValue, encryptedSelf = encryptedSelf)
      is EncryptedTypedValue -> copy(type = type, booleanValue = booleanValue, integerValue =
          integerValue, doubleValue = doubleValue, stringValue = stringValue, dateValue = dateValue,
          encryptedSelf = encryptedSelf)
                                          }

}