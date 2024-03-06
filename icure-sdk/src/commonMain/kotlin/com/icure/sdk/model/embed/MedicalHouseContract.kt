package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class MedicalHouseContract(
  public val contractId: String? = null,
  public val validFrom: Long? = null,
  public val validTo: Long? = null,
  public val mmNihii: String? = null,
  public val hcpId: String? = null,
  public val changeType: ContractChangeType? = null,
  public val parentContractId: String? = null,
  public val changedBy: String? = null,
  public val startOfContract: Long? = null,
  public val startOfCoverage: Long? = null,
  public val endOfContract: Long? = null,
  public val endOfCoverage: Long? = null,
  public val kine: Boolean = false,
  public val gp: Boolean = false,
  public val ptd: Boolean = false,
  public val nurse: Boolean = false,
  public val noKine: Boolean = false,
  public val noGp: Boolean = false,
  public val noNurse: Boolean = false,
  public val unsubscriptionReasonId: Int? = null,
  public val ptdStart: Long? = null,
  public val ptdEnd: Long? = null,
  public val ptdLastInvoiced: Long? = null,
  public val startOfSuspension: Long? = null,
  public val endOfSuspension: Long? = null,
  public val suspensionReason: SuspensionReason? = null,
  public val suspensionSource: String? = null,
  public val forcedSuspension: Boolean = false,
  public val signatureType: MhcSignatureType? = null,
  public val status: Int? = null,
  public val options: Map<String, String> = emptyMap(),
  public val receipts: Map<String, String> = emptyMap(),
  override val encryptedSelf: String? = null,
) : Encrypted
