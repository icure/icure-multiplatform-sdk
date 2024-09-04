// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("MedicalHouseContract")
public sealed external interface MedicalHouseContractJs : EncryptableJs {
	public val contractId: String?

	public val validFrom: Double?

	public val validTo: Double?

	public val mmNihii: String?

	public val hcpId: String?

	public val changeType: String?

	public val parentContractId: String?

	public val changedBy: String?

	public val startOfContract: Double?

	public val startOfCoverage: Double?

	public val endOfContract: Double?

	public val endOfCoverage: Double?

	public val kine: Boolean

	public val gp: Boolean

	public val ptd: Boolean

	public val nurse: Boolean

	public val noKine: Boolean

	public val noGp: Boolean

	public val noNurse: Boolean

	public val unsubscriptionReasonId: Double?

	public val ptdStart: Double?

	public val ptdEnd: Double?

	public val ptdLastInvoiced: Double?

	public val startOfSuspension: Double?

	public val endOfSuspension: Double?

	public val suspensionReason: String?

	public val suspensionSource: String?

	public val forcedSuspension: Boolean

	public val signatureType: String?

	public val status: Double?

	public val options: Record<String, out String>

	public val receipts: Record<String, out String>

	public val isEncrypted: Boolean
}

@JsName("DecryptedMedicalHouseContract")
public external class DecryptedMedicalHouseContractJs(
	partial: dynamic,
) : MedicalHouseContractJs {
	override val contractId: String?

	override val validFrom: Double?

	override val validTo: Double?

	override val mmNihii: String?

	override val hcpId: String?

	override val changeType: String?

	override val parentContractId: String?

	override val changedBy: String?

	override val startOfContract: Double?

	override val startOfCoverage: Double?

	override val endOfContract: Double?

	override val endOfCoverage: Double?

	override val kine: Boolean

	override val gp: Boolean

	override val ptd: Boolean

	override val nurse: Boolean

	override val noKine: Boolean

	override val noGp: Boolean

	override val noNurse: Boolean

	override val unsubscriptionReasonId: Double?

	override val ptdStart: Double?

	override val ptdEnd: Double?

	override val ptdLastInvoiced: Double?

	override val startOfSuspension: Double?

	override val endOfSuspension: Double?

	override val suspensionReason: String?

	override val suspensionSource: String?

	override val forcedSuspension: Boolean

	override val signatureType: String?

	override val status: Double?

	override val options: Record<String, String>

	override val receipts: Record<String, String>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}

@JsName("EncryptedMedicalHouseContract")
public external class EncryptedMedicalHouseContractJs(
	partial: dynamic,
) : MedicalHouseContractJs {
	override val contractId: String?

	override val validFrom: Double?

	override val validTo: Double?

	override val mmNihii: String?

	override val hcpId: String?

	override val changeType: String?

	override val parentContractId: String?

	override val changedBy: String?

	override val startOfContract: Double?

	override val startOfCoverage: Double?

	override val endOfContract: Double?

	override val endOfCoverage: Double?

	override val kine: Boolean

	override val gp: Boolean

	override val ptd: Boolean

	override val nurse: Boolean

	override val noKine: Boolean

	override val noGp: Boolean

	override val noNurse: Boolean

	override val unsubscriptionReasonId: Double?

	override val ptdStart: Double?

	override val ptdEnd: Double?

	override val ptdLastInvoiced: Double?

	override val startOfSuspension: Double?

	override val endOfSuspension: Double?

	override val suspensionReason: String?

	override val suspensionSource: String?

	override val forcedSuspension: Boolean

	override val signatureType: String?

	override val status: Double?

	override val options: Record<String, String>

	override val receipts: Record<String, String>

	override val encryptedSelf: String?

	override val isEncrypted: Boolean
}
