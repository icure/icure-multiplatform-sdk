package com.icure.sdk.model

import com.icure.sdk.model.embed.DecryptedTypedValue
import com.icure.sdk.model.embed.Encrypted
import com.icure.sdk.model.embed.EncryptedTypedValue
import com.icure.sdk.model.embed.TypedValue
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public sealed interface PropertyStub : Encrypted {
  public val id: String?

  public val type: PropertyTypeStub?

  public val typedValue: TypedValue<*>?

  public val deletionDate: Long?

  override val encryptedSelf: String?
}

public data class DecryptedPropertyStub(
  override val id: String? = null,
  override val type: PropertyTypeStub? = null,
  override val typedValue: DecryptedTypedValue<*>? = null,
  override val deletionDate: Long? = null,
  override val encryptedSelf: String? = null,
) : PropertyStub

public data class EncryptedPropertyStub(
  override val id: String? = null,
  override val type: PropertyTypeStub? = null,
  override val typedValue: EncryptedTypedValue<*>? = null,
  override val deletionDate: Long? = null,
  override val encryptedSelf: String? = null,
) : PropertyStub

public fun PropertyStub.copy(
  id: String? = this.id,
  type: PropertyTypeStub? = this.type,
  typedValue: TypedValue<*>? = this.typedValue,
  deletionDate: Long? = this.deletionDate,
  encryptedSelf: String? = this.encryptedSelf,
): PropertyStub {
                                      return when(this) {
                                          is DecryptedPropertyStub -> copy(id = id, type = type,
          typedValue = typedValue, deletionDate = deletionDate, encryptedSelf = encryptedSelf)
      is EncryptedPropertyStub -> copy(id = id, type = type, typedValue = typedValue, deletionDate =
          deletionDate, encryptedSelf = encryptedSelf)
                                          }
}
