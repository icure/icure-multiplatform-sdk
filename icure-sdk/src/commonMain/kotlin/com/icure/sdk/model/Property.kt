package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DecryptedTypedValue
import com.icure.sdk.model.embed.Encrypted
import com.icure.sdk.model.embed.EncryptedTypedValue
import com.icure.sdk.model.embed.TypedValue
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Property : StoredDocument, Encrypted {
  override val id: String

  override val rev: String?

  override val deletionDate: Long?

  public val type: PropertyType?

  public val typedValue: TypedValue<*>?

  override val encryptedSelf: String?
}

public data class DecryptedProperty(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val type: PropertyType? = null,
  override val typedValue: DecryptedTypedValue<*>? = null,
  override val encryptedSelf: String? = null,
) : Property

public data class EncryptedProperty(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val type: PropertyType? = null,
  override val typedValue: EncryptedTypedValue<*>? = null,
  override val encryptedSelf: String? = null,
) : Property

public fun Property.copy(
  id: String = this.id,
  rev: String? = this.rev,
  deletionDate: Long? = this.deletionDate,
  type: PropertyType? = this.type,
  typedValue: TypedValue<*>? = this.typedValue,
  encryptedSelf: String? = this.encryptedSelf,
): Property {
                                      return when(this) {
                                          is DecryptedProperty -> copy(id = id, rev = rev,
          deletionDate = deletionDate, type = type, typedValue = typedValue, encryptedSelf =
          encryptedSelf)
      is EncryptedProperty -> copy(id = id, rev = rev, deletionDate = deletionDate, type = type,
          typedValue = typedValue, encryptedSelf = encryptedSelf)
                                          }
}