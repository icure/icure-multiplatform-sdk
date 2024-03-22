package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Telecom : Encrypted {
  public val telecomType: TelecomType?

  public val telecomNumber: String?

  public val telecomDescription: String?

  override val encryptedSelf: String?
}

public data class DecryptedTelecom(
  override val telecomType: TelecomType? = null,
  override val telecomNumber: String? = null,
  override val telecomDescription: String? = null,
  override val encryptedSelf: String? = null,
) : Telecom

public data class EncryptedTelecom(
  override val telecomType: TelecomType? = null,
  override val telecomNumber: String? = null,
  override val telecomDescription: String? = null,
  override val encryptedSelf: String? = null,
) : Telecom

public fun Telecom.copy(
  telecomType: TelecomType? = this.telecomType,
  telecomNumber: String? = this.telecomNumber,
  telecomDescription: String? = this.telecomDescription,
  encryptedSelf: String? = this.encryptedSelf,
): Telecom {
                                      return when(this) {
                                          is DecryptedTelecom -> copy(telecomType = telecomType,
          telecomNumber = telecomNumber, telecomDescription = telecomDescription, encryptedSelf =
          encryptedSelf)
      is EncryptedTelecom -> copy(telecomType = telecomType, telecomNumber = telecomNumber,
          telecomDescription = telecomDescription, encryptedSelf = encryptedSelf)
                                          }
}
