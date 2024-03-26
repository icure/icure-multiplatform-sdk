package com.icure.sdk.model.embed

import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface Valorisation : Encryptable {
  public val startOfValidity: Long?

  public val endOfValidity: Long?

  public val predicate: String?

  public val reference: List<Int>?

  public val totalAmount: Double?

  public val reimbursement: Double?

  public val patientIntervention: Double?

  public val doctorSupplement: Double?

  public val vat: Double?

  public val label: Map<String, String>?

  override val encryptedSelf: String?
}

@SerialName
public data class DecryptedValorisation(
  override val startOfValidity: Long? = null,
  override val endOfValidity: Long? = null,
  override val predicate: String? = null,
  override val reference: List<Int>? = null,
  override val totalAmount: Double? = null,
  override val reimbursement: Double? = null,
  override val patientIntervention: Double? = null,
  override val doctorSupplement: Double? = null,
  override val vat: Double? = null,
  override val label: Map<String, String>? = null,
  override val encryptedSelf: String? = null,
) : Valorisation

@SerialName
public data class EncryptedValorisation(
  override val startOfValidity: Long? = null,
  override val endOfValidity: Long? = null,
  override val predicate: String? = null,
  override val reference: List<Int>? = null,
  override val totalAmount: Double? = null,
  override val reimbursement: Double? = null,
  override val patientIntervention: Double? = null,
  override val doctorSupplement: Double? = null,
  override val vat: Double? = null,
  override val label: Map<String, String>? = null,
  override val encryptedSelf: String? = null,
) : Valorisation

public fun Valorisation.copy(
  startOfValidity: Long? = this.startOfValidity,
  endOfValidity: Long? = this.endOfValidity,
  predicate: String? = this.predicate,
  reference: List<Int>? = this.reference,
  totalAmount: Double? = this.totalAmount,
  reimbursement: Double? = this.reimbursement,
  patientIntervention: Double? = this.patientIntervention,
  doctorSupplement: Double? = this.doctorSupplement,
  vat: Double? = this.vat,
  label: Map<String, String>? = this.label,
  encryptedSelf: String? = this.encryptedSelf,
): Valorisation {
                                      return when(this) {
                                          is DecryptedValorisation -> copy(startOfValidity =
          startOfValidity, endOfValidity = endOfValidity, predicate = predicate, reference =
          reference, totalAmount = totalAmount, reimbursement = reimbursement, patientIntervention =
          patientIntervention, doctorSupplement = doctorSupplement, vat = vat, label = label,
          encryptedSelf = encryptedSelf)
      is EncryptedValorisation -> copy(startOfValidity = startOfValidity, endOfValidity =
          endOfValidity, predicate = predicate, reference = reference, totalAmount = totalAmount,
          reimbursement = reimbursement, patientIntervention = patientIntervention, doctorSupplement
          = doctorSupplement, vat = vat, label = label, encryptedSelf = encryptedSelf)
                                          }
}
