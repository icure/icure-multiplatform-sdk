package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Telecom : Encryptable {
  public val telecomType: TelecomType?

  public val telecomNumber: String?

  public val telecomDescription: String?

  override val encryptedSelf: Base64String?
	// region Telecom-Telecom
	// endregion
}

data class DecryptedTelecom(
	override val telecomType: TelecomType? = null,
	override val telecomNumber: String? = null,
	override val telecomDescription: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Telecom {
	// region Telecom-DecryptedTelecom
	// endregion
}

data class EncryptedTelecom(
	override val telecomType: TelecomType? = null,
	override val telecomNumber: String? = null,
	override val telecomDescription: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Telecom {
	// region Telecom-EncryptedTelecom
	// endregion
}

public fun Telecom.copy(
  telecomType: TelecomType? = this.telecomType,
  telecomNumber: String? = this.telecomNumber,
  telecomDescription: String? = this.telecomDescription,
  encryptedSelf: Base64String? = this.encryptedSelf,
): Telecom {
                                      return when(this) {
                                          is DecryptedTelecom -> copy(telecomType = telecomType,
          telecomNumber = telecomNumber, telecomDescription = telecomDescription, encryptedSelf =
          encryptedSelf)
      is EncryptedTelecom -> copy(telecomType = telecomType, telecomNumber = telecomNumber,
          telecomDescription = telecomDescription, encryptedSelf = encryptedSelf)
                                          }

}