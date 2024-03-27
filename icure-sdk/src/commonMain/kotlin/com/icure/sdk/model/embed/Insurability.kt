package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface Insurability : Encryptable {
  public val parameters: Map<String, String>

  public val hospitalisation: Boolean?

  public val ambulatory: Boolean?

  public val dental: Boolean?

  public val identificationNumber: String?

  public val insuranceId: String?

  public val startDate: Long?

  public val endDate: Long?

  public val titularyId: String?

  override val encryptedSelf: Base64String?
	// region Insurability-Insurability
	// endregion
}


@Serializable
data class DecryptedInsurability(
	override val parameters: Map<String, String> = emptyMap(),
	override val hospitalisation: Boolean? = null,
	override val ambulatory: Boolean? = null,
	override val dental: Boolean? = null,
	override val identificationNumber: String? = null,
	override val insuranceId: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val titularyId: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Insurability {
	// region Insurability-DecryptedInsurability
	// endregion
}


@Serializable
data class EncryptedInsurability(
	override val parameters: Map<String, String> = emptyMap(),
	override val hospitalisation: Boolean? = null,
	override val ambulatory: Boolean? = null,
	override val dental: Boolean? = null,
	override val identificationNumber: String? = null,
	override val insuranceId: String? = null,
	override val startDate: Long? = null,
	override val endDate: Long? = null,
	override val titularyId: String? = null,
	override val encryptedSelf: Base64String? = null,
) : Insurability {
	// region Insurability-EncryptedInsurability
	// endregion
}

public fun Insurability.copy(
  parameters: Map<String, String> = this.parameters,
  hospitalisation: Boolean? = this.hospitalisation,
  ambulatory: Boolean? = this.ambulatory,
  dental: Boolean? = this.dental,
  identificationNumber: String? = this.identificationNumber,
  insuranceId: String? = this.insuranceId,
  startDate: Long? = this.startDate,
  endDate: Long? = this.endDate,
  titularyId: String? = this.titularyId,
  encryptedSelf: Base64String? = this.encryptedSelf,
): Insurability {
                                      return when(this) {
                                          is DecryptedInsurability -> copy(parameters = parameters,
          hospitalisation = hospitalisation, ambulatory = ambulatory, dental = dental,
          identificationNumber = identificationNumber, insuranceId = insuranceId, startDate =
          startDate, endDate = endDate, titularyId = titularyId, encryptedSelf = encryptedSelf)
      is EncryptedInsurability -> copy(parameters = parameters, hospitalisation = hospitalisation,
          ambulatory = ambulatory, dental = dental, identificationNumber = identificationNumber,
          insuranceId = insuranceId, startDate = startDate, endDate = endDate, titularyId =
          titularyId, encryptedSelf = encryptedSelf)
                                          }

}
