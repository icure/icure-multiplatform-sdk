package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface InvoicingCode : Encryptable {
  public val id: String?

  public val dateCode: Long?

  public val logicalId: String?

  public val label: String?

  public val userId: String?

  public val contactId: String?

  public val serviceId: String?

  public val tarificationId: String?

  public val code: String?

  public val paymentType: PaymentType?

  public val paid: Double?

  public val totalAmount: Double?

  public val reimbursement: Double?

  public val patientIntervention: Double?

  public val doctorSupplement: Double?

  public val conventionAmount: Double?

  public val vat: Double?

  public val error: String?

  public val contract: String?

  public val contractDate: Long?

  public val units: Int?

  public val side: Int?

  public val timeOfDay: Int?

  public val eidReadingHour: Int?

  public val eidReadingValue: String?

  public val override3rdPayerCode: Int?

  public val override3rdPayerReason: String?

  public val transplantationCode: Int?

  public val prescriberNorm: Int?

  public val percentNorm: Int?

  public val prescriberNihii: String?

  public val relatedCode: String?

  public val prescriptionDate: Long?

  public val derogationMaxNumber: Int?

  public val prescriberSsin: String?

  public val prescriberLastName: String?

  public val prescriberFirstName: String?

  public val prescriberCdHcParty: String?

  public val locationNihii: String?

  public val locationCdHcParty: String?

  public val locationService: Int?

  public val admissionDate: Long?

  public val canceled: Boolean?

  public val accepted: Boolean?

  public val pending: Boolean?

  public val resent: Boolean?

  public val archived: Boolean?

  public val lost: Boolean?

  public val insuranceJustification: Int?

  public val cancelPatientInterventionReason: Int?

  public val status: Long?

  override val encryptedSelf: String?
}

@SerialName
public data class DecryptedInvoicingCode(
  override val id: String? = null,
  override val dateCode: Long? = null,
  override val logicalId: String? = null,
  override val label: String? = null,
  override val userId: String? = null,
  override val contactId: String? = null,
  override val serviceId: String? = null,
  override val tarificationId: String? = null,
  override val code: String? = null,
  override val paymentType: PaymentType? = null,
  override val paid: Double? = null,
  override val totalAmount: Double? = null,
  override val reimbursement: Double? = null,
  override val patientIntervention: Double? = null,
  override val doctorSupplement: Double? = null,
  override val conventionAmount: Double? = null,
  override val vat: Double? = null,
  override val error: String? = null,
  override val contract: String? = null,
  override val contractDate: Long? = null,
  override val units: Int? = null,
  override val side: Int? = null,
  override val timeOfDay: Int? = null,
  override val eidReadingHour: Int? = null,
  override val eidReadingValue: String? = null,
  override val override3rdPayerCode: Int? = null,
  override val override3rdPayerReason: String? = null,
  override val transplantationCode: Int? = null,
  override val prescriberNorm: Int? = null,
  override val percentNorm: Int? = null,
  override val prescriberNihii: String? = null,
  override val relatedCode: String? = null,
  override val prescriptionDate: Long? = null,
  override val derogationMaxNumber: Int? = null,
  override val prescriberSsin: String? = null,
  override val prescriberLastName: String? = null,
  override val prescriberFirstName: String? = null,
  override val prescriberCdHcParty: String? = null,
  override val locationNihii: String? = null,
  override val locationCdHcParty: String? = null,
  override val locationService: Int? = null,
  override val admissionDate: Long? = null,
  override val canceled: Boolean? = null,
  override val accepted: Boolean? = null,
  override val pending: Boolean? = null,
  override val resent: Boolean? = null,
  override val archived: Boolean? = null,
  override val lost: Boolean? = null,
  override val insuranceJustification: Int? = null,
  override val cancelPatientInterventionReason: Int? = null,
  override val status: Long? = null,
  override val encryptedSelf: String? = null,
) : InvoicingCode

@SerialName
public data class EncryptedInvoicingCode(
  override val id: String? = null,
  override val dateCode: Long? = null,
  override val logicalId: String? = null,
  override val label: String? = null,
  override val userId: String? = null,
  override val contactId: String? = null,
  override val serviceId: String? = null,
  override val tarificationId: String? = null,
  override val code: String? = null,
  override val paymentType: PaymentType? = null,
  override val paid: Double? = null,
  override val totalAmount: Double? = null,
  override val reimbursement: Double? = null,
  override val patientIntervention: Double? = null,
  override val doctorSupplement: Double? = null,
  override val conventionAmount: Double? = null,
  override val vat: Double? = null,
  override val error: String? = null,
  override val contract: String? = null,
  override val contractDate: Long? = null,
  override val units: Int? = null,
  override val side: Int? = null,
  override val timeOfDay: Int? = null,
  override val eidReadingHour: Int? = null,
  override val eidReadingValue: String? = null,
  override val override3rdPayerCode: Int? = null,
  override val override3rdPayerReason: String? = null,
  override val transplantationCode: Int? = null,
  override val prescriberNorm: Int? = null,
  override val percentNorm: Int? = null,
  override val prescriberNihii: String? = null,
  override val relatedCode: String? = null,
  override val prescriptionDate: Long? = null,
  override val derogationMaxNumber: Int? = null,
  override val prescriberSsin: String? = null,
  override val prescriberLastName: String? = null,
  override val prescriberFirstName: String? = null,
  override val prescriberCdHcParty: String? = null,
  override val locationNihii: String? = null,
  override val locationCdHcParty: String? = null,
  override val locationService: Int? = null,
  override val admissionDate: Long? = null,
  override val canceled: Boolean? = null,
  override val accepted: Boolean? = null,
  override val pending: Boolean? = null,
  override val resent: Boolean? = null,
  override val archived: Boolean? = null,
  override val lost: Boolean? = null,
  override val insuranceJustification: Int? = null,
  override val cancelPatientInterventionReason: Int? = null,
  override val status: Long? = null,
  override val encryptedSelf: String? = null,
) : InvoicingCode

public fun InvoicingCode.copy(
  id: String? = this.id,
  dateCode: Long? = this.dateCode,
  logicalId: String? = this.logicalId,
  label: String? = this.label,
  userId: String? = this.userId,
  contactId: String? = this.contactId,
  serviceId: String? = this.serviceId,
  tarificationId: String? = this.tarificationId,
  code: String? = this.code,
  paymentType: PaymentType? = this.paymentType,
  paid: Double? = this.paid,
  totalAmount: Double? = this.totalAmount,
  reimbursement: Double? = this.reimbursement,
  patientIntervention: Double? = this.patientIntervention,
  doctorSupplement: Double? = this.doctorSupplement,
  conventionAmount: Double? = this.conventionAmount,
  vat: Double? = this.vat,
  error: String? = this.error,
  contract: String? = this.contract,
  contractDate: Long? = this.contractDate,
  units: Int? = this.units,
  side: Int? = this.side,
  timeOfDay: Int? = this.timeOfDay,
  eidReadingHour: Int? = this.eidReadingHour,
  eidReadingValue: String? = this.eidReadingValue,
  override3rdPayerCode: Int? = this.override3rdPayerCode,
  override3rdPayerReason: String? = this.override3rdPayerReason,
  transplantationCode: Int? = this.transplantationCode,
  prescriberNorm: Int? = this.prescriberNorm,
  percentNorm: Int? = this.percentNorm,
  prescriberNihii: String? = this.prescriberNihii,
  relatedCode: String? = this.relatedCode,
  prescriptionDate: Long? = this.prescriptionDate,
  derogationMaxNumber: Int? = this.derogationMaxNumber,
  prescriberSsin: String? = this.prescriberSsin,
  prescriberLastName: String? = this.prescriberLastName,
  prescriberFirstName: String? = this.prescriberFirstName,
  prescriberCdHcParty: String? = this.prescriberCdHcParty,
  locationNihii: String? = this.locationNihii,
  locationCdHcParty: String? = this.locationCdHcParty,
  locationService: Int? = this.locationService,
  admissionDate: Long? = this.admissionDate,
  canceled: Boolean? = this.canceled,
  accepted: Boolean? = this.accepted,
  pending: Boolean? = this.pending,
  resent: Boolean? = this.resent,
  archived: Boolean? = this.archived,
  lost: Boolean? = this.lost,
  insuranceJustification: Int? = this.insuranceJustification,
  cancelPatientInterventionReason: Int? = this.cancelPatientInterventionReason,
  status: Long? = this.status,
  encryptedSelf: String? = this.encryptedSelf,
): InvoicingCode {
                                      return when(this) {
                                          is DecryptedInvoicingCode -> copy(id = id, dateCode =
          dateCode, logicalId = logicalId, label = label, userId = userId, contactId = contactId,
          serviceId = serviceId, tarificationId = tarificationId, code = code, paymentType =
          paymentType, paid = paid, totalAmount = totalAmount, reimbursement = reimbursement,
          patientIntervention = patientIntervention, doctorSupplement = doctorSupplement,
          conventionAmount = conventionAmount, vat = vat, error = error, contract = contract,
          contractDate = contractDate, units = units, side = side, timeOfDay = timeOfDay,
          eidReadingHour = eidReadingHour, eidReadingValue = eidReadingValue, override3rdPayerCode =
          override3rdPayerCode, override3rdPayerReason = override3rdPayerReason, transplantationCode
          = transplantationCode, prescriberNorm = prescriberNorm, percentNorm = percentNorm,
          prescriberNihii = prescriberNihii, relatedCode = relatedCode, prescriptionDate =
          prescriptionDate, derogationMaxNumber = derogationMaxNumber, prescriberSsin =
          prescriberSsin, prescriberLastName = prescriberLastName, prescriberFirstName =
          prescriberFirstName, prescriberCdHcParty = prescriberCdHcParty, locationNihii =
          locationNihii, locationCdHcParty = locationCdHcParty, locationService = locationService,
          admissionDate = admissionDate, canceled = canceled, accepted = accepted, pending =
          pending, resent = resent, archived = archived, lost = lost, insuranceJustification =
          insuranceJustification, cancelPatientInterventionReason = cancelPatientInterventionReason,
          status = status, encryptedSelf = encryptedSelf)
      is EncryptedInvoicingCode -> copy(id = id, dateCode = dateCode, logicalId = logicalId, label =
          label, userId = userId, contactId = contactId, serviceId = serviceId, tarificationId =
          tarificationId, code = code, paymentType = paymentType, paid = paid, totalAmount =
          totalAmount, reimbursement = reimbursement, patientIntervention = patientIntervention,
          doctorSupplement = doctorSupplement, conventionAmount = conventionAmount, vat = vat, error
          = error, contract = contract, contractDate = contractDate, units = units, side = side,
          timeOfDay = timeOfDay, eidReadingHour = eidReadingHour, eidReadingValue = eidReadingValue,
          override3rdPayerCode = override3rdPayerCode, override3rdPayerReason =
          override3rdPayerReason, transplantationCode = transplantationCode, prescriberNorm =
          prescriberNorm, percentNorm = percentNorm, prescriberNihii = prescriberNihii, relatedCode
          = relatedCode, prescriptionDate = prescriptionDate, derogationMaxNumber =
          derogationMaxNumber, prescriberSsin = prescriberSsin, prescriberLastName =
          prescriberLastName, prescriberFirstName = prescriberFirstName, prescriberCdHcParty =
          prescriberCdHcParty, locationNihii = locationNihii, locationCdHcParty = locationCdHcParty,
          locationService = locationService, admissionDate = admissionDate, canceled = canceled,
          accepted = accepted, pending = pending, resent = resent, archived = archived, lost = lost,
          insuranceJustification = insuranceJustification, cancelPatientInterventionReason =
          cancelPatientInterventionReason, status = status, encryptedSelf = encryptedSelf)
                                          }
}
