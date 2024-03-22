package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public sealed interface MedicalHouseContract : Encrypted {
  public val contractId: String?

  public val validFrom: Long?

  public val validTo: Long?

  public val mmNihii: String?

  public val hcpId: String?

  public val changeType: ContractChangeType?

  public val parentContractId: String?

  public val changedBy: String?

  public val startOfContract: Long?

  public val startOfCoverage: Long?

  public val endOfContract: Long?

  public val endOfCoverage: Long?

  public val kine: Boolean

  public val gp: Boolean

  public val ptd: Boolean

  public val nurse: Boolean

  public val noKine: Boolean

  public val noGp: Boolean

  public val noNurse: Boolean

  public val unsubscriptionReasonId: Int?

  public val ptdStart: Long?

  public val ptdEnd: Long?

  public val ptdLastInvoiced: Long?

  public val startOfSuspension: Long?

  public val endOfSuspension: Long?

  public val suspensionReason: SuspensionReason?

  public val suspensionSource: String?

  public val forcedSuspension: Boolean

  public val signatureType: MhcSignatureType?

  public val status: Int?

  public val options: Map<String, String>

  public val receipts: Map<String, String>

  override val encryptedSelf: String?
}

public data class DecryptedMedicalHouseContract(
  override val contractId: String? = null,
  override val validFrom: Long? = null,
  override val validTo: Long? = null,
  override val mmNihii: String? = null,
  override val hcpId: String? = null,
  override val changeType: ContractChangeType? = null,
  override val parentContractId: String? = null,
  override val changedBy: String? = null,
  override val startOfContract: Long? = null,
  override val startOfCoverage: Long? = null,
  override val endOfContract: Long? = null,
  override val endOfCoverage: Long? = null,
  override val kine: Boolean = false,
  override val gp: Boolean = false,
  override val ptd: Boolean = false,
  override val nurse: Boolean = false,
  override val noKine: Boolean = false,
  override val noGp: Boolean = false,
  override val noNurse: Boolean = false,
  override val unsubscriptionReasonId: Int? = null,
  override val ptdStart: Long? = null,
  override val ptdEnd: Long? = null,
  override val ptdLastInvoiced: Long? = null,
  override val startOfSuspension: Long? = null,
  override val endOfSuspension: Long? = null,
  override val suspensionReason: SuspensionReason? = null,
  override val suspensionSource: String? = null,
  override val forcedSuspension: Boolean = false,
  override val signatureType: MhcSignatureType? = null,
  override val status: Int? = null,
  override val options: Map<String, String> = emptyMap(),
  override val receipts: Map<String, String> = emptyMap(),
  override val encryptedSelf: String? = null,
) : MedicalHouseContract

public data class EncryptedMedicalHouseContract(
  override val contractId: String? = null,
  override val validFrom: Long? = null,
  override val validTo: Long? = null,
  override val mmNihii: String? = null,
  override val hcpId: String? = null,
  override val changeType: ContractChangeType? = null,
  override val parentContractId: String? = null,
  override val changedBy: String? = null,
  override val startOfContract: Long? = null,
  override val startOfCoverage: Long? = null,
  override val endOfContract: Long? = null,
  override val endOfCoverage: Long? = null,
  override val kine: Boolean = false,
  override val gp: Boolean = false,
  override val ptd: Boolean = false,
  override val nurse: Boolean = false,
  override val noKine: Boolean = false,
  override val noGp: Boolean = false,
  override val noNurse: Boolean = false,
  override val unsubscriptionReasonId: Int? = null,
  override val ptdStart: Long? = null,
  override val ptdEnd: Long? = null,
  override val ptdLastInvoiced: Long? = null,
  override val startOfSuspension: Long? = null,
  override val endOfSuspension: Long? = null,
  override val suspensionReason: SuspensionReason? = null,
  override val suspensionSource: String? = null,
  override val forcedSuspension: Boolean = false,
  override val signatureType: MhcSignatureType? = null,
  override val status: Int? = null,
  override val options: Map<String, String> = emptyMap(),
  override val receipts: Map<String, String> = emptyMap(),
  override val encryptedSelf: String? = null,
) : MedicalHouseContract

public fun MedicalHouseContract.copy(
  contractId: String? = this.contractId,
  validFrom: Long? = this.validFrom,
  validTo: Long? = this.validTo,
  mmNihii: String? = this.mmNihii,
  hcpId: String? = this.hcpId,
  changeType: ContractChangeType? = this.changeType,
  parentContractId: String? = this.parentContractId,
  changedBy: String? = this.changedBy,
  startOfContract: Long? = this.startOfContract,
  startOfCoverage: Long? = this.startOfCoverage,
  endOfContract: Long? = this.endOfContract,
  endOfCoverage: Long? = this.endOfCoverage,
  kine: Boolean = this.kine,
  gp: Boolean = this.gp,
  ptd: Boolean = this.ptd,
  nurse: Boolean = this.nurse,
  noKine: Boolean = this.noKine,
  noGp: Boolean = this.noGp,
  noNurse: Boolean = this.noNurse,
  unsubscriptionReasonId: Int? = this.unsubscriptionReasonId,
  ptdStart: Long? = this.ptdStart,
  ptdEnd: Long? = this.ptdEnd,
  ptdLastInvoiced: Long? = this.ptdLastInvoiced,
  startOfSuspension: Long? = this.startOfSuspension,
  endOfSuspension: Long? = this.endOfSuspension,
  suspensionReason: SuspensionReason? = this.suspensionReason,
  suspensionSource: String? = this.suspensionSource,
  forcedSuspension: Boolean = this.forcedSuspension,
  signatureType: MhcSignatureType? = this.signatureType,
  status: Int? = this.status,
  options: Map<String, String> = this.options,
  receipts: Map<String, String> = this.receipts,
  encryptedSelf: String? = this.encryptedSelf,
): MedicalHouseContract {
                                      return when(this) {
                                          is DecryptedMedicalHouseContract -> copy(contractId =
          contractId, validFrom = validFrom, validTo = validTo, mmNihii = mmNihii, hcpId = hcpId,
          changeType = changeType, parentContractId = parentContractId, changedBy = changedBy,
          startOfContract = startOfContract, startOfCoverage = startOfCoverage, endOfContract =
          endOfContract, endOfCoverage = endOfCoverage, kine = kine, gp = gp, ptd = ptd, nurse =
          nurse, noKine = noKine, noGp = noGp, noNurse = noNurse, unsubscriptionReasonId =
          unsubscriptionReasonId, ptdStart = ptdStart, ptdEnd = ptdEnd, ptdLastInvoiced =
          ptdLastInvoiced, startOfSuspension = startOfSuspension, endOfSuspension = endOfSuspension,
          suspensionReason = suspensionReason, suspensionSource = suspensionSource, forcedSuspension
          = forcedSuspension, signatureType = signatureType, status = status, options = options,
          receipts = receipts, encryptedSelf = encryptedSelf)
      is EncryptedMedicalHouseContract -> copy(contractId = contractId, validFrom = validFrom,
          validTo = validTo, mmNihii = mmNihii, hcpId = hcpId, changeType = changeType,
          parentContractId = parentContractId, changedBy = changedBy, startOfContract =
          startOfContract, startOfCoverage = startOfCoverage, endOfContract = endOfContract,
          endOfCoverage = endOfCoverage, kine = kine, gp = gp, ptd = ptd, nurse = nurse, noKine =
          noKine, noGp = noGp, noNurse = noNurse, unsubscriptionReasonId = unsubscriptionReasonId,
          ptdStart = ptdStart, ptdEnd = ptdEnd, ptdLastInvoiced = ptdLastInvoiced, startOfSuspension
          = startOfSuspension, endOfSuspension = endOfSuspension, suspensionReason =
          suspensionReason, suspensionSource = suspensionSource, forcedSuspension =
          forcedSuspension, signatureType = signatureType, status = status, options = options,
          receipts = receipts, encryptedSelf = encryptedSelf)
                                          }
}
