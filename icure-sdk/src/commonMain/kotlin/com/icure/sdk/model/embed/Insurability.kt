package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Insurability : Encrypted {
  public val parameters: Map<String, String>

  public val hospitalisation: Boolean?

  public val ambulatory: Boolean?

  public val dental: Boolean?

  public val identificationNumber: String?

  public val insuranceId: String?

  public val startDate: Long?

  public val endDate: Long?

  public val titularyId: String?

  override val encryptedSelf: String?
}

public data class DecryptedInsurability(
  override val parameters: Map<String, String> = emptyMap(),
  override val hospitalisation: Boolean? = null,
  override val ambulatory: Boolean? = null,
  override val dental: Boolean? = null,
  override val identificationNumber: String? = null,
  override val insuranceId: String? = null,
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val titularyId: String? = null,
  override val encryptedSelf: String? = null,
) : Insurability

public data class EncryptedInsurability(
  override val parameters: Map<String, String> = emptyMap(),
  override val hospitalisation: Boolean? = null,
  override val ambulatory: Boolean? = null,
  override val dental: Boolean? = null,
  override val identificationNumber: String? = null,
  override val insuranceId: String? = null,
  override val startDate: Long? = null,
  override val endDate: Long? = null,
  override val titularyId: String? = null,
  override val encryptedSelf: String? = null,
) : Insurability

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
  encryptedSelf: String? = this.encryptedSelf,
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
