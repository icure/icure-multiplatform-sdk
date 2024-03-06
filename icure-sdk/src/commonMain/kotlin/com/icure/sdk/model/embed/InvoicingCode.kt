package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Comparable
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class InvoicingCode(
  public val id: String? = null,
  public val dateCode: Long? = null,
  public val logicalId: String? = null,
  public val label: String? = null,
  public val userId: String? = null,
  public val contactId: String? = null,
  public val serviceId: String? = null,
  public val tarificationId: String? = null,
  public val code: String? = null,
  public val paymentType: PaymentType? = null,
  public val paid: Double? = null,
  public val totalAmount: Double? = null,
  public val reimbursement: Double? = null,
  public val patientIntervention: Double? = null,
  public val doctorSupplement: Double? = null,
  public val conventionAmount: Double? = null,
  public val vat: Double? = null,
  public val error: String? = null,
  public val contract: String? = null,
  public val contractDate: Long? = null,
  public val units: Int? = null,
  public val side: Int? = null,
  public val timeOfDay: Int? = null,
  public val eidReadingHour: Int? = null,
  public val eidReadingValue: String? = null,
  public val override3rdPayerCode: Int? = null,
  public val override3rdPayerReason: String? = null,
  public val transplantationCode: Int? = null,
  public val prescriberNorm: Int? = null,
  public val percentNorm: Int? = null,
  public val prescriberNihii: String? = null,
  public val relatedCode: String? = null,
  public val prescriptionDate: Long? = null,
  public val derogationMaxNumber: Int? = null,
  public val prescriberSsin: String? = null,
  public val prescriberLastName: String? = null,
  public val prescriberFirstName: String? = null,
  public val prescriberCdHcParty: String? = null,
  public val locationNihii: String? = null,
  public val locationCdHcParty: String? = null,
  public val locationService: Int? = null,
  public val admissionDate: Long? = null,
  public val canceled: Boolean? = null,
  public val accepted: Boolean? = null,
  public val pending: Boolean? = null,
  public val resent: Boolean? = null,
  public val archived: Boolean? = null,
  public val lost: Boolean? = null,
  public val insuranceJustification: Int? = null,
  public val cancelPatientInterventionReason: Int? = null,
  public val status: Long? = null,
  override val encryptedSelf: String? = null,
) : Encrypted, Comparable<InvoicingCode?>
